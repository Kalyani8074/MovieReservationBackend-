package com.movie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.entites.Admin;

import jakarta.transaction.Transactional;

@Repository

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
