package edu.mum.service;

import java.util.List;

import edu.mum.domain.Order;

public interface OrderService {

	void publishOrder(Order order);

	void save(Order order);

	List<Order> findAll();

	Order findById(Long id);

	void update(Order o);

}
