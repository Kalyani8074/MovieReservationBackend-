package com.movie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.entites.ScheduleShow;

@Repository
public interface Schedule_ShowRepository extends JpaRepository<ScheduleShow, Long> {

}
