package com.projcrud.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projcrud.course.entites.Order;
import com.projcrud.course.repositories.OrderRepository;

@Service
public class OrderServices {

	@Autowired
	private OrderRepository Repository;

	public List<Order> findAll() {
		return Repository.findAll();
	}

	public Order findById(Long id) {
		Optional<Order> obj = Repository.findById(id);
		return obj.get();
	}

}
