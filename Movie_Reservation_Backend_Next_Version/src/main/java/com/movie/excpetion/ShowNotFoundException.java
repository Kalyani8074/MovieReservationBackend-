package com.movie.excpetion;

public class ShowNotFoundException extends RuntimeException {
	
	public ShowNotFoundException(String msg){
		super(msg);
	}

}
