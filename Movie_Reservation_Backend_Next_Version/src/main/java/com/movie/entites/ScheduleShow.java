package com.movie.entites;

import java.time.LocalTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class ScheduleShow {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	  private long scheduleId;
	
	@OneToOne(cascade = CascadeType.ALL)
 	 private SeatLayout seatLayout;
	  private LocalTime showTime;
}
