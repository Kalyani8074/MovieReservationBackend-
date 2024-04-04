package com.movie.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movie.response.AuthenticationResponse;
import com.movie.entites.Users;
import com.movie.excpetion.UserEmailIdExistsException;
import com.movie.services.AuthenticationService;
import com.movie.utility.Role;

@RestController
@CrossOrigin("http://localhost:4200")
public class AuthenticationController {
	
	private final AuthenticationService authService;

	public AuthenticationController(AuthenticationService authService) {
		super();
		this.authService = authService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody Users user) throws UserEmailIdExistsException
	{
		 return ResponseEntity.ok(authService.register(user));
	}
	
	@PostMapping("/adminRegister")
	public ResponseEntity<AuthenticationResponse> registerAdmin(@RequestBody Users user) throws UserEmailIdExistsException
	{    
		 user.setRole(Role.ADMIN);
		 return ResponseEntity.ok(authService.register(user));
	}

	@PostMapping("/login")
	public ResponseEntity<AuthenticationResponse>  login(@RequestBody Users request) throws Exception{
		
		return ResponseEntity.ok(authService.authenticate(request));
	}
	
	@GetMapping("/test")
	public ResponseEntity<String> testLogin()
	{
		System.out.println("Success accessed");
		return ResponseEntity.ok("Secured url");
	}
	
	
}
