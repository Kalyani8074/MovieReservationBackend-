package com.movie.excpetion;

public class SeatNotFoundException extends RuntimeException {
	
	public SeatNotFoundException(String msg){
		super(msg);
	}

}
