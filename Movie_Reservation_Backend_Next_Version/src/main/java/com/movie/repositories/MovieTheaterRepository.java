package com.movie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.entites.MovieTheater;

@Repository
public interface MovieTheaterRepository extends JpaRepository<MovieTheater, Long> {

}
