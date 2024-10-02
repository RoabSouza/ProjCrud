package com.projcrud.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projcrud.course.entites.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
