package com.movie.controller;

import com.movie.entites.*;
import com.movie.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.movie.services.BookingService;
import com.movie.utility.SeatCategory;
import com.movie.utility.SeatStatus;

import java.util.*;

@RestController
@RequestMapping("/booking")
@CrossOrigin(origins = "http://localhost:4200")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;

	@PutMapping("/bookSeats/{seatId}")
	public Seat bookSeats(@PathVariable("seatId") long id,@RequestBody Seat seats)
	{ 

		return bookingService.bookSeats(id,seats);
	}

	@PostMapping("/bookSeats")
	public TicketResponse bookTicket(@RequestBody TicketRequest ticketRequest){
       System.out.println(ticketRequest);
		return bookingService.bookTicket(ticketRequest,ticketRequest.getBookedSeats());
	}


}
