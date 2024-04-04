package com.movie.excpetion;

public class AdminNotFoundException extends RuntimeException {
	
	public AdminNotFoundException(String msg){
		super(msg);
	}

}
