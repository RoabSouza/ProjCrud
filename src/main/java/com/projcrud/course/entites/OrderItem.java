package com.projcrud.course.entites;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projcrud.course.entites.pk.OrderItemPk;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {

	private static final long seralVersionUID = 1L;
	
	@EmbeddedId
	private OrderItemPk Id = new OrderItemPk();
	
	private Integer quantity;
	private double price;

	public OrderItem() {

	}

	public OrderItem(Order order, Product product, Integer quantity, double price) {
		super();
		Id.setOrder(order);
		Id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}

	@JsonIgnore
	public Order getOrder() {
		return Id.getOrder();
	}

	public void setOrder(Order order) {
		Id.setOrder(order);
	}

	
	public Product getProductr() {
		return Id.getProduct();
	}

	public void setProduct(Product product) {
		Id.setProduct(product);
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getsubTotal() {
		return price * quantity;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(Id, other.Id);
	}

}
