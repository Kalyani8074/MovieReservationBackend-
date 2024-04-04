package com.movie.iservices;

import java.util.Map;


import com.movie.entites.SeatLayout;

public interface ISeatLayoutService {

	public SeatLayout createSeatLayout(int numRows, int seatsPerRow);

	public SeatLayout updateSeatLayoutCategory(long seatLayoutId, Map<String, String[]> seatCategory);
	
	public SeatLayout getSeatLayout(long seatLayoutId);

}
