package com.movie.excpetion;

public class UserEmailIdExistsException extends Exception {
	
	public UserEmailIdExistsException(String msg){
		super(msg);
	}

}
