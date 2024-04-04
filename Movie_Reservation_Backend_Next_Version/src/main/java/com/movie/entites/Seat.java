package com.movie.entites;

import com.movie.utility.SeatCategory;
import com.movie.utility.SeatStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Seat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long seatId;
	private int rowNumber;
	private int colNumber;
	private String seatName;
	private SeatStatus seatStatus;
	private SeatCategory seatCategory;
	private double price;

}
