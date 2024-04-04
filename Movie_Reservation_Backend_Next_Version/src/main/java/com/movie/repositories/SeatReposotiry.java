package com.movie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.entites.Seat;

@Repository
public interface SeatReposotiry extends JpaRepository<Seat, Long> {

}
