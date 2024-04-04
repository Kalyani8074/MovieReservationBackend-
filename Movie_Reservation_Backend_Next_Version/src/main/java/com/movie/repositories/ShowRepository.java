package com.movie.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.movie.entites.Show;

@Repository

public interface ShowRepository extends JpaRepository<Show, Long> {

	  @Query("SELECT DISTINCT s FROM Show s " +
	           "JOIN FETCH s.movie m " + // Eagerly fetch Movie
	           "LEFT JOIN FETCH s.movieTheater mt " + // Lazily fetch MovieTheater
	           "LEFT JOIN FETCH s.scheduleShows ss " + // Lazily fetch ScheduleShows
	           "ORDER BY s.showId ASC")
	    List<Show> findAllShowsWithAssociations();
	
}
