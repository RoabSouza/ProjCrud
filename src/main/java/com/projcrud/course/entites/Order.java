package com.projcrud.course.entites;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projcrud.course.entites.enums.OrderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyy-MM-dd 'T 'HH:mm:ss' Z'", timezone = "GMT")
	private Instant momet;

	private Integer orderStatus;

	@ManyToOne
	@JoinColumn(name = "client_name")
	private User client;

	@OneToMany(mappedBy = "Id.order")
	private Set<OrderItem> items = new HashSet<>();

	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private Payment payement;

	public Order() {

	}

	public Order(Long id, Instant momet, User client, OrderStatus orderStatus) {
		super();
		this.id = id;
		this.momet = momet;
		this.client = client;
		setOrderStatus(orderStatus);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMomet() {
		return momet;
	}

	public void setMomet(Instant momet) {
		this.momet = momet;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		if (orderStatus != null) {

			this.orderStatus = orderStatus.getCode();
		}

	}

	public Payment getPayement() {
		return payement;
	}

	public void setPayement(Payment payement) {
		this.payement = payement;
	}

	public Set<OrderItem> getItems() {
		return items;
	}

	public double getTotal() {
		double sum = 0.0;

		for (OrderItem x : items) {
			sum = sum + x.getsubTotal();
		}
		return sum;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}

}
