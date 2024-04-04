package com.movie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.entites.SeatLayout;

@Repository
public interface SeatLayoutRepository extends JpaRepository<SeatLayout, Long> {

}
