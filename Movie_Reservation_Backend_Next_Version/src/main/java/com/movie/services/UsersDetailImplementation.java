package com.movie.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.movie.repositories.UsersRepository;

@Service
public class UsersDetailImplementation implements  UserDetailsService	 {

	
	private final UsersRepository usersRepository;
	
	public UsersDetailImplementation(UsersRepository repository) {
		this.usersRepository = repository;
	}
	
	@Override	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return usersRepository.findByUserName(username)
				               .orElseThrow(()-> new UsernameNotFoundException("User not found"));
	}

}
