package com.movie.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.entites.Movie;
import com.movie.excpetion.MovieIdExistException;
import com.movie.excpetion.MovieNotFoundException;
import com.movie.iservices.IMovieService;
import com.movie.mappers.MovieMapper;
import com.movie.repositories.MovieRepository;

@Service
public class MovieService implements IMovieService {

	@Autowired
	private MovieRepository movieRepository;

	private MovieMapper movieMapper;

	@Override
	public Movie registerMovie(Movie movie) throws MovieIdExistException {

		if (movieRepository.existsById(movie.getMovieId())) {
			throw new MovieIdExistException("The movie id already exist");
		}

		return movieRepository.save(movie);
	}

	@Override
	public Movie updateMovie(long movieId, Movie movie) throws MovieNotFoundException {

		Movie existingMovie = movieRepository.findById(movieId)
				.orElseThrow(() -> new MovieNotFoundException("Movie not found with id: " + movieId));

		System.out.println("Update movie");
		existingMovie = mapProperties(movie, existingMovie); // updating properties

		return movieRepository.save(existingMovie);
	}

	@Override
	public void deleteMovie(Long movieId) throws MovieNotFoundException {

		if (!movieRepository.existsById(movieId)) {
			throw new MovieNotFoundException("Movie details not exist cannot remove");
		}

		movieRepository.deleteById(movieId);

	}

	@Override
	public Movie getMovieById(Long movieId) throws MovieNotFoundException {

		Optional<Movie> movie = movieRepository.findById(movieId);
		if (movie.isEmpty())
			throw new MovieNotFoundException("Movie Not Found");

		return movie.get();
	}

	@Override
	public List<Movie> getAllMovies() {

		return movieRepository.findAll();
	}

	public Movie mapProperties(Movie newMovie, Movie existMovie) {
		existMovie.setMovieName(newMovie.getMovieName());
		existMovie.setDirectorName(newMovie.getDirectorName());
		existMovie.setReleaseDate(newMovie.getReleaseDate());
		existMovie.setDuration(newMovie.getDuration());
		existMovie.setLanguages(newMovie.getLanguages());
		existMovie.setImageData(newMovie.getImageData());
		existMovie.setDescription(newMovie.getDescription());

		return existMovie;
	}

	public Movie getMovieImagedata(String movieName){


		return movieRepository.findByMovieName(movieName);
	}
}
