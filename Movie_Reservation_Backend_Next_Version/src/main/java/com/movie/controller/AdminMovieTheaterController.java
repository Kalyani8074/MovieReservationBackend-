package com.movie.controller;

import java.util.List;
import java.util.Map;

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

import com.movie.entites.MovieTheater;
import com.movie.entites.SeatLayout;
import com.movie.excpetion.MovieTheaterIdExistException;
import com.movie.excpetion.MovieTheaterNotFoundException;
import com.movie.iservices.IAdminMovieTheaterService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/adminMovieTheater")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminMovieTheaterController {

	@Autowired
	private IAdminMovieTheaterService adminMovieTheaterService;

	@PostMapping("/addMovieTheater")
	public MovieTheater movieRegistration(@Valid @RequestBody MovieTheater movie) throws MovieTheaterIdExistException {
		return adminMovieTheaterService.registerMovieTheater(movie);
	}

	@GetMapping("/getMovieTheaters")
	public List<MovieTheater> getAllMovieTheaters() {
		return adminMovieTheaterService.getAllMovieTheaters();
	}
	
	@GetMapping("/getMovieTheaterById/{movieTheaterId}")
	public MovieTheater getMovieTheaterById(@PathVariable("movieTheaterId") long movieTheaterId)
	{
		 return adminMovieTheaterService.getMovieTheaterById(movieTheaterId);
	}

	@PutMapping("/updateMovieTheater/{movieId}")
	public MovieTheater updateMovieTheater(@PathVariable("movieId") long movieId, @RequestBody MovieTheater movie)
			throws MovieTheaterNotFoundException {
		return adminMovieTheaterService.updateMovieTheater(movieId, movie);
	}

	@PutMapping("/updateSeatLayout/{seatLayoutId}")  // Update the seat layout category after completion of movie theater registration 
	public SeatLayout updateSeatLayoutCategory(@PathVariable("seatLayoutId") long seatLayoutId,
			@RequestBody Map<String, String[]> seatCategory) {
    System.out.println("SeatLayout "+seatLayoutId);
    System.out.println();
    System.out.println("Map : "+seatCategory);
    seatCategory.entrySet().forEach(System.out::println);
		return adminMovieTheaterService.updateSeatLayoutCategory(seatLayoutId, seatCategory);
	}

	@DeleteMapping("/deleteMovieTheater/{movieId}")
	public ResponseEntity<String> deleteMovieTheater(@PathVariable("movieId") long movieId) {

		try {

			adminMovieTheaterService.deleteMovieTheater(movieId);
			return ResponseEntity.ok("MovieTheater removed successfully");

		} catch (MovieTheaterNotFoundException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("MovieTheater not found");
		}

	}

}
