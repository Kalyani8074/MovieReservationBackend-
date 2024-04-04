package com.movie.entites;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long movieId;
	
	@NotNull(message="Movie name is mandatory")
	 @Size(min = 3, max = 45, message = "Movie name must be between 3 and 45 characters")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Movie name must not contain special characters except space")    
	private String movieName;
	
	@NotNull(message = "Director name is mandatory")
	@Size(max = 45, message = "Director name must be at most 45 characters")
    @Pattern(regexp = "[a-zA-Z ]*", message = "Director name must contain only alphabetic characters and spaces")   
	private String directorName;
	
	 @NotNull(message = "Release date is required")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
	private Date releaseDate;
	 
	 @NotNull(message = "Duration is required")
	 @Pattern(regexp = "\\d{2}:\\d{2}", message = "Duration must be in the format HH:mm")
	private String duration;
	 
	 @Size(min = 1, message = "At least one language must be specified")
	private List<String> languages;

	 @NotNull(message = "Image data is mandatory")
	@Lob
	private byte[] imageData;
	 
	 @Size(min = 3,max = 200, message = "Description must be at most 200 characters")
	private String description;

}
