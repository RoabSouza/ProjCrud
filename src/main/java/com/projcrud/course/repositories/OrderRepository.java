package com.projcrud.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projcrud.course.entites.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
	

}
