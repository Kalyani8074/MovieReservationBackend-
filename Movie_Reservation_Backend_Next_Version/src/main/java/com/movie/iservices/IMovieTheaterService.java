package com.movie.iservices;

import java.util.List;

import com.movie.entites.MovieTheater;
import com.movie.entites.SeatLayout;
import com.movie.excpetion.MovieTheaterIdExistException;
import com.movie.excpetion.MovieTheaterNotFoundException;

public interface IMovieTheaterService {

	public MovieTheater registerMovieTheater(MovieTheater movie) throws MovieTheaterIdExistException;

	public MovieTheater updateMovieTheater(long theaterId, MovieTheater movie) throws MovieTheaterNotFoundException;

	public void deleteMovieTheater(Long movieId) throws MovieTheaterNotFoundException;

	public MovieTheater getMovieTheaterById(Long movieId) throws MovieTheaterNotFoundException;

	public List<MovieTheater> getAllMovieTheaters();
	


}
