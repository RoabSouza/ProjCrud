package com.projcrud.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projcrud.course.entites.Category;
import com.projcrud.course.entites.Order;
import com.projcrud.course.entites.OrderItem;
import com.projcrud.course.entites.Payment;
import com.projcrud.course.entites.Product;
import com.projcrud.course.entites.User;
import com.projcrud.course.entites.enums.OrderStatus;
import com.projcrud.course.repositories.CategoryRepository;
import com.projcrud.course.repositories.OrderItemRepository;
import com.projcrud.course.repositories.OrderRepository;
import com.projcrud.course.repositories.ProductRepository;
import com.projcrud.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productrepository;

	@Autowired
	private OrderItemRepository orderitemrepository;

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		productrepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);

		productrepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.PAID);
		Order o2 = new Order(null, Instant.parse("2013-03-24T16:55:09Z"), u1, OrderStatus.CANCELED);
		Order o3 = new Order(null, Instant.parse("2012-02-23T17:57:08Z"), u2, OrderStatus.SHIPPED);

		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));

		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

		orderitemrepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

		Payment pay1 = new Payment(null, Instant.parse("2024-06-20T21:53:07Z"), o1);
		o1.setPayement(pay1);
		
		orderRepository.save(o1);

	}

}
