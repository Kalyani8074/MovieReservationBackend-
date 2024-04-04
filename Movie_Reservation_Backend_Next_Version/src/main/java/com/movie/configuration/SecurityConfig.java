package com.movie.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.movie.filter.JwtAuthenticationFilter;
import com.movie.services.UsersDetailImplementation;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	
	private final UsersDetailImplementation userDetailsServiceImp;
	
	private final JwtAuthenticationFilter authenticationFilter;
	
	
	
	public SecurityConfig(UsersDetailImplementation userDetailsServiceImp,
			JwtAuthenticationFilter authenticationFilter) {
		super();
		this.userDetailsServiceImp = userDetailsServiceImp;
		this.authenticationFilter = authenticationFilter;
	}



	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		
		return http
				.csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(
				                 req-> req.requestMatchers("/login/**","/register/**","/adminMovie/getMovies/**",
				                		 "/adminShow/getShows/**","/booking/bookSeats/**","/booking/bookTicket/**",
				                		 "/seatLayout/getSeatLayout/**","/adminShow/addShow/**","/adminShow/getById/**",
				                          "/adminMovie/addMovie/**","/adminMovie/getMovieImage/**","/adminMovie/updateMovie/**","/adminMovie/getMovie/**",
				                		 "/adminMovieTheater/addMovieTheater/**","/adminMovieTheater/getMovieTheaters/**","/adminMovieTheater/getMovieTheaterById/**",
				                		 "/adminMovieTheater/updateMovieTheater/**","/adminMovieTheater/updateSeatLayout/**","/adminRegister/**")
				                 .permitAll()
				                 .anyRequest()
				                 .authenticated()
				
						).userDetailsService(userDetailsServiceImp)
				         .sessionManagement(session -> session
				        		                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				         .addFilterBefore(authenticationFilter,UsernamePasswordAuthenticationFilter.class)
				         .build();
	
	} 
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		 return new BCryptPasswordEncoder();
	}
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		 return configuration.getAuthenticationManager();
	}

}
