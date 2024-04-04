package com.movie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.entites.Movie;

import java.util.*;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

   public Movie findByMovieName(String movieName);

  // public byte[] findImageDataByMovieId(long id);





}
