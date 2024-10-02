package com.projcrud.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projcrud.course.entites.Product;
import com.projcrud.course.repositories.ProductRepository;

@Service
public class ProductServices {

	@Autowired
	private ProductRepository Repository;

	public List<Product> findAll() {
		return Repository.findAll();
	}

	public Product findById(Long id) {
		Optional<Product> obj = Repository.findById(id);
		return obj.get();
	}

}
