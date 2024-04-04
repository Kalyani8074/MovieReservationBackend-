package com.movie.iservices;

import java.util.List;

import com.movie.entites.Movie;
import com.movie.excpetion.MovieIdExistException;
import com.movie.excpetion.MovieNotFoundException;

public interface IMovieService {

	public Movie registerMovie(Movie movie) throws MovieIdExistException;

	public Movie updateMovie(long movieId, Movie movie) throws MovieNotFoundException;

	public void deleteMovie(Long movieId) throws MovieNotFoundException;

	public Movie getMovieById(Long movieId) throws MovieNotFoundException;

	public List<Movie> getAllMovies();

	public Movie getMovieImagedata(String movieName);

}
