package com.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.entites.Movie;
import com.movie.excpetion.MovieIdExistException;
import com.movie.excpetion.MovieNotFoundException;
import com.movie.iservices.IAdminMovieService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/adminMovie")
public class AdminMovieController {

	@Autowired
	private IAdminMovieService adminMovieService;

	@PostMapping("/addMovie")
	public Movie movieRegistration(@Valid @RequestBody Movie movie) throws MovieIdExistException {
		System.out.println("Movie Invoked ");
		return adminMovieService.registerMovie(movie);
	}

	@GetMapping("/getMovies")
	public List<Movie> getAllMovies() {
		
		return adminMovieService.getAllMovies();
	}
	
	@GetMapping("/getMovie/{movieId}")
	public Movie getMovie(@PathVariable("movieId") long movieId) throws MovieNotFoundException {
    
		return adminMovieService.getMovieById(movieId);
	}


	@PutMapping("/updateMovie/{movieId}")
	public Movie updateMovie(@PathVariable("movieId") long movieId, @RequestBody Movie movie)
			throws MovieNotFoundException {
		return adminMovieService.updateMovie(movieId, movie);
	}

	@DeleteMapping("/deleteMovie/{movieId}")
	public ResponseEntity<String> deleteMovie(@PathVariable("movieId") long movieId) {

		try {
			
			adminMovieService.deleteMovie(movieId);
			return ResponseEntity.ok("Movie removed successfully");
			
		} catch (MovieNotFoundException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie not found");
		}

	}

	@GetMapping("/getMovieImage/{movieName}")
	public Movie getMovieImage(@PathVariable  String movieName){
         return adminMovieService.getMovieImagedata(movieName);
	}

}
