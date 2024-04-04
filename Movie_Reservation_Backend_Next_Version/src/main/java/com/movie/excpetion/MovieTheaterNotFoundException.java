package com.movie.excpetion;

public class MovieTheaterNotFoundException extends RuntimeException {
	
	public MovieTheaterNotFoundException(String msg){
		super(msg);
	}

}
