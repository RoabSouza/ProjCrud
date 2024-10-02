package com.projcrud.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projcrud.course.entites.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
