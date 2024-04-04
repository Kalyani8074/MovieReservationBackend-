package com.movie.entites;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Show {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long showId;
	@ManyToOne()
	private Movie movie;
	@ManyToOne()
	private MovieTheater movieTheater;
	@OneToMany(cascade = CascadeType.ALL)
	private List< ScheduleShow> scheduleShows;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
	  private LocalDate date;
	  private String showLanguage;
	
	

}
