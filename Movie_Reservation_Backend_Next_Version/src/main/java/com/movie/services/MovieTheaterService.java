package com.movie.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.entites.MovieTheater;
import com.movie.excpetion.MovieTheaterIdExistException;
import com.movie.excpetion.MovieTheaterNotFoundException;
import com.movie.iservices.IMovieTheaterService;
import com.movie.repositories.MovieTheaterRepository;

@Service
public class MovieTheaterService implements IMovieTheaterService {

	@Autowired
	private MovieTheaterRepository movieTheaterRepository;

	@Override
	public MovieTheater registerMovieTheater(MovieTheater movie) throws MovieTheaterIdExistException {

		return movieTheaterRepository.save(movie);
	}

	@Override
	public MovieTheater updateMovieTheater(long id, MovieTheater movie) throws MovieTheaterNotFoundException {

		MovieTheater existingMovieTheater = movieTheaterRepository.findById(id)
				.orElseThrow(() -> new MovieTheaterNotFoundException("Movie theater not found with id: " + id));    System.out.println("Movie Theater Invoked");
		existingMovieTheater = mapProperties(movie, existingMovieTheater);
		return movieTheaterRepository.save(existingMovieTheater);
	}

	@Override
	public void deleteMovieTheater(Long movieId) throws MovieTheaterNotFoundException {

		if (!movieTheaterRepository.existsById(movieId)) {
			throw new MovieTheaterNotFoundException("MovieTheater details not exist cannot remove");
		}

		movieTheaterRepository.deleteById(movieId);

	}

	@Override
	public MovieTheater getMovieTheaterById(Long movieId) throws MovieTheaterNotFoundException {

		Optional<MovieTheater> movie = movieTheaterRepository.findById(movieId);
		if (movie.isEmpty())
			throw new MovieTheaterNotFoundException("MovieTheater Not Found");

		return movie.get();
	}

	@Override
	public List<MovieTheater> getAllMovieTheaters() {

		return movieTheaterRepository.findAll();
	}

	public MovieTheater mapProperties(MovieTheater newMovieTheater, MovieTheater existingMovieTheater) {
		existingMovieTheater.setCity(newMovieTheater.getCity());
		existingMovieTheater.setState(newMovieTheater.getState());
		existingMovieTheater.setTheaterName(newMovieTheater.getTheaterName());
		existingMovieTheater.setOwnerName(newMovieTheater.getOwnerName());
		existingMovieTheater.setPhoneNumber(newMovieTheater.getPhoneNumber());
		existingMovieTheater.setAadhar(newMovieTheater.getAadhar());
		existingMovieTheater.setScreens(newMovieTheater.getScreens());
		existingMovieTheater.setNumberOfRows(newMovieTheater.getNumberOfRows());
		existingMovieTheater.setSeatsPerRow(newMovieTheater.getSeatsPerRow());
		existingMovieTheater.setSeatLayout(newMovieTheater.getSeatLayout());
		existingMovieTheater.setOpeningTime(newMovieTheater.getOpeningTime());
		existingMovieTheater.setClosingTime(newMovieTheater.getClosingTime());

		return existingMovieTheater;

	}

}
