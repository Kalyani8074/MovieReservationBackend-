package com.movie.services;

import com.movie.entites.*;
import com.movie.iservices.*;
import com.movie.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.excpetion.SeatNotFoundException;
import com.movie.repositories.SeatReposotiry;

import java.time.*;
import java.util.*;
import java.util.stream.*;

@Service
public class BookingService implements IBookingService {
	
	@Autowired
	 private SeatReposotiry seatRepository;

	@Autowired
	private ITicketService ticketService;

	@Override
	public Seat bookSeats(long id,Seat seats) {
	 
		Seat seat = new Seat();
		if(seatRepository.existsById(id))
		{

			return seatRepository.save(seats);
		}else
		{
			throw new SeatNotFoundException("Seat Not Found");
		}
		
	}

	public TicketResponse bookTicket(TicketRequest ticketRequest,List<Seat> seats){
     double totalPrice = 0.0;
		List<String> bookedTickets = seats.stream()
				.map( (seat)->{
					Seat s = new Seat();
                      s=  this.bookSeats(seat.getSeatId(),seat);

					  return s.getSeatName()+s.getColNumber();
				}).collect(Collectors.toList());

		totalPrice = seats.stream()
				.mapToDouble(Seat::getPrice)
				.sum();
		System.out.println("Total Price : "+totalPrice);
		Ticket ticket = new Ticket();

		System.out.println(CustomerProfileSessionService.getCustomerData());
		ticket.setUserId(CustomerProfileSessionService.getCustomerData());
		ticket.setBookedTime(LocalTime.now());
		ticket.setBookedSeats(bookedTickets);
		ticket.setMovieName(ticketRequest.getMovieName());
		ticket.setMovieTheaterName(ticketRequest.getMovieTheaterName());
		ticket.setShowTime(ticketRequest.getShowTime());
		ticket.setShowDate(ticketRequest.getShowDate());

		return createTicketResponse(ticketService.createTicket(ticket));

	}


	public TicketResponse createTicketResponse(Ticket ticket)
	{

		TicketResponse ticketResponse = new TicketResponse();

		UsersResponse usersResponse = userToUserResponse(ticket.getUserId());

		ticketResponse.setUser(usersResponse);
		ticketResponse.setMovieName(ticket.getMovieName());
		ticketResponse.setMovieTheaterName(ticket.getMovieTheaterName());
		ticketResponse.setShowTime(ticket.getShowTime());
		ticketResponse.setShowDate(ticket.getShowDate());
		ticketResponse.setFormattedShowDate();
		ticketResponse.setBookedSeats(ticket.getBookedSeats());
		ticketResponse.setTicketId(ticket.getTicketId());
		return ticketResponse;

	}

	public UsersResponse userToUserResponse(Users user){
		UsersResponse usersResponse = new UsersResponse();
		usersResponse.setUserName(user.getUsername());
		usersResponse.setFirstName(user.getFirstName());
		usersResponse.setLastName(user.getLastName());
		usersResponse.setEmailId(user.getEmailId());
		usersResponse.setMobileNo(user.getMobileNo());

		return usersResponse;
	}
	
	

}
