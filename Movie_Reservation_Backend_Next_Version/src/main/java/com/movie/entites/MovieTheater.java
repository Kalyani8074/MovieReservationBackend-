package com.movie.entites;

import java.time.LocalTime;

import com.movie.controller.AadharSequence;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
public class MovieTheater {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long theaterId;
	@NotBlank(message = "City is mandatory")
	@Pattern(regexp = "^[a-zA-Z\\s]{3,45}$", message = "City name must contain only letters and spaces, with length between 3 and 45")
	private String city;

	@NotBlank(message = "State is mandatory")
	@Pattern(regexp = "^[a-zA-Z\\s]{3,45}$", message = "State name must contain only letters and spaces, with length between 3 and 45")
	private String state;

	@NotBlank(message = "Theater name is mandatory")
	@Pattern(regexp = "^[a-zA-Z\\s]{3,45}$", message = "Theater name must contain only letters and spaces, with length between 3 and 45")
	private String theaterName;

	@NotBlank(message = "Owner name is mandatory")
	@Pattern(regexp = "^[a-zA-Z\\s]{3,45}$", message = "Owner name must contain only letters and spaces, with length between 3 and 45")
    private String ownerName;

	@NotBlank(message = "Phone number required")
	@Pattern(regexp = "^[6-9]\\d{9}$", message = "Phone number must be 10 digits and start with 6, 7, 8, or 9")
	private String phoneNumber;

	@NotBlank(message = "Aadhaar Number required")
	@Pattern(regexp = "^[2-9]\\d{11}$", message = "Aadhaar number must be 12 digits and cannot start with 0 or 1")
	@AadharSequence(message = "Aadhar number contains a sequence of repeated digits.")
	private String aadhar;

	@NotNull(message = "Number of screens is mandatory")
	private int screens;
	
	@NotNull(message = "Number of rows is mandatory")
	private int numberOfRows;
	
	@NotNull(message = "Number of seats per row is mandatory")
	private int seatsPerRow;

	@OneToOne(cascade = CascadeType.ALL)
	private SeatLayout seatLayout;
	
	@NotNull(message = "Opening time is mandatory")
	private LocalTime openingTime;
	
	@NotNull(message = "Closing time is mandatory")
	private LocalTime closingTime;

}
