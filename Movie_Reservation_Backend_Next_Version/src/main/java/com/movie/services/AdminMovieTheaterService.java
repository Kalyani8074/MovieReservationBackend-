package com.movie.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.entites.MovieTheater;
import com.movie.entites.SeatLayout;
import com.movie.excpetion.MovieTheaterIdExistException;
import com.movie.excpetion.MovieTheaterNotFoundException;
import com.movie.iservices.IAdminMovieTheaterService;
import com.movie.iservices.IMovieTheaterService;
import com.movie.iservices.ISeatLayoutService;

@Service
public class AdminMovieTheaterService implements IAdminMovieTheaterService {
	
	@Autowired
	private IMovieTheaterService movieTheaterService;

	@Autowired
	private ISeatLayoutService seatLayoutService;
	
	@Override
	public MovieTheater registerMovieTheater(MovieTheater movie) throws MovieTheaterIdExistException {
		
           SeatLayout seatLayout = createSeatLayout(movie.getNumberOfRows(),movie.getSeatsPerRow());

          movie.setSeatLayout(seatLayout);     // Assigning default seat layout to the movie theater
            
           
		return movieTheaterService.registerMovieTheater(movie);
	}

	@Override
	public MovieTheater updateMovieTheater(long theaterId, MovieTheater movie) throws MovieTheaterNotFoundException {

		return movieTheaterService.updateMovieTheater(theaterId, movie);
	}

	@Override
	public void deleteMovieTheater(Long movieId) throws MovieTheaterNotFoundException {
		movieTheaterService.deleteMovieTheater(movieId);

	}

	@Override
	public MovieTheater getMovieTheaterById(Long movieId) throws MovieTheaterNotFoundException {

		return movieTheaterService.getMovieTheaterById(movieId);
	}

	@Override
	public List<MovieTheater> getAllMovieTheaters() {

		return movieTheaterService.getAllMovieTheaters();
	}

	@Override
	public SeatLayout createSeatLayout(int numRows, int seatsPerRow) {
	
		return seatLayoutService.createSeatLayout(numRows, seatsPerRow);
	}

	@Override
	public SeatLayout updateSeatLayoutCategory(long seatLayoutId, Map<String, String[]> seatCategory) {
		
		return seatLayoutService.updateSeatLayoutCategory(seatLayoutId, seatCategory);
	}

	@Override
	public SeatLayout getSeatLayout(long seatLayoutId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
