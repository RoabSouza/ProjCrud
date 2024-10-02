package com.projcrud.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projcrud.course.entites.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	

}
