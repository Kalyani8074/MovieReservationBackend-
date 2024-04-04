package com.movie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.entites.Customer;

@Repository
public interface CustomerRespository extends JpaRepository<Customer, Long> {

}
