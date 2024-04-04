package com.movie.iservices;

import java.util.List;

import com.movie.entites.Seat;
import com.movie.entites.SeatLayout;

public interface IBookingService {
	
	public Seat bookSeats(long id,Seat seat);


}
