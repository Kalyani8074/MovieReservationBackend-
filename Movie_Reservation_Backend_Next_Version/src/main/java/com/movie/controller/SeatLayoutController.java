package com.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.entites.SeatLayout;
import com.movie.services.SeatLayoutService;

@RestController
@RequestMapping("/seatLayout")
@CrossOrigin(origins = "http://localhost:4200")
public class SeatLayoutController{
	
	@Autowired
	private SeatLayoutService seatLayoutService;

	@GetMapping("/getSeatLayout/{seatLayoutId}")
	public SeatLayout getSeatLayout(@PathVariable("seatLayoutId") long id)
	{
		return seatLayoutService.getSeatLayout(id);
	}

}
