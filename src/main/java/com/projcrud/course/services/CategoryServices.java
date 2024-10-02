package com.projcrud.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projcrud.course.entites.Category;
import com.projcrud.course.repositories.CategoryRepository;

@Service
public class CategoryServices {

	@Autowired
	private CategoryRepository Repository;

	public List<Category> findAll() {
		return Repository.findAll();
	}

	public Category findById(Long id) {
		Optional<Category> obj = Repository.findById(id);
		return obj.get();
	}

}
