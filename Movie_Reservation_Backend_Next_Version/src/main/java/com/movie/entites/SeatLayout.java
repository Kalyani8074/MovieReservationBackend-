package com.movie.entites;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class SeatLayout {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long seatLayoutId;
	
	private int numRows;
	private int seatsPerRow;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Seat> seats;
	

}
