package com.projcrud.course.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projcrud.course.entites.Product;
import com.projcrud.course.services.ProductServices;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	@Autowired
	private ProductServices Service;

	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = Service.findAll();
		return ResponseEntity.ok().body(list);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product obj = Service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	
}
