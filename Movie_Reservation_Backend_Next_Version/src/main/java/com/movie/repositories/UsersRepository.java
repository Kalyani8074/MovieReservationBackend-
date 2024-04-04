package com.movie.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.entites.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer>{

	   Optional<Users>  findByUserName(String userName);
	   
	  Optional<Users>  findByEmailId(String emailId);
}
