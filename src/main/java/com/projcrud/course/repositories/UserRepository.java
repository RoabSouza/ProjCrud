package com.projcrud.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projcrud.course.entites.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	

}
