package com.movie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.entites.Movie;
import com.movie.excpetion.MovieIdExistException;
import com.movie.excpetion.MovieNotFoundException;
import com.movie.iservices.IAdminMovieService;
import com.movie.iservices.IMovieService;

@Service
public class AdminMovieService implements IAdminMovieService {

	@Autowired
	private IMovieService movieService;

	@Override
	public Movie registerMovie(Movie movie) throws MovieIdExistException {

		return movieService.registerMovie(movie);
	}

	@Override
	public Movie updateMovie(long movieId, Movie movie) throws MovieNotFoundException {

		return movieService.updateMovie(movieId, movie);
	}

	@Override
	public void deleteMovie(Long movieId) throws MovieNotFoundException {
		movieService.deleteMovie(movieId);

	}

	@Override
	public Movie getMovieById(Long movieId) throws MovieNotFoundException {

		return movieService.getMovieById(movieId);
	}

	@Override
	public List<Movie> getAllMovies() {

		return movieService.getAllMovies();
	}

	@Override
	public Movie getMovieImagedata(String movieName) {
		return movieService.getMovieImagedata(movieName);
	}



}
