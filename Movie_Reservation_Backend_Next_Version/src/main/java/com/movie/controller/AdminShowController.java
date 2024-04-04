package com.movie.controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.entites.Show;
import com.movie.excpetion.ShowNotFoundException;
import com.movie.iservices.IAdminShowService;

@RestController
@RequestMapping("/adminShow")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminShowController {

	@Autowired
	private IAdminShowService adminShowService;

	@PostMapping("/addShow")
	public Show showRegistration(@RequestBody Show show)  {
		System.out.println("show : "+show);
		return adminShowService.registerShow(show);
	}

	@PutMapping("/updateShow/{showId}")
	public Show updateShow(@PathVariable("showId") long showId, @RequestBody Show show)
			throws ShowNotFoundException {
		return adminShowService.updateShow(showId, show);
	}
	
	@GetMapping("/getShows/{movie}/{date}/{city}/{language}")
	public List<Show>  getShows(@PathVariable String movie, @PathVariable LocalDate date, @PathVariable String city,@PathVariable String language) throws ParseException
	{
		System.out.println("local date : "+date);
		  java.util.Date utilDate = java.sql.Date.valueOf(date);
		  System.out.println("util  date"+utilDate);
		 return adminShowService.getShowsByMovieAndDateAndCityAndLanguage(movie, date, city, language);
	}
	
	
	@GetMapping("/getAllShows")
	public List<Show> getAllShows()
	{
		return adminShowService.getAllShows();
	}



	@GetMapping("/getById/{showId}")
	public Show getById(@PathVariable("showId") long id) {
		// TODO Auto-generated method stub
		return adminShowService.getById(id);
	}
}
