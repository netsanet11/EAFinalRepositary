package edu.mum.listener;

import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.domain.Order;
import edu.mum.service.OrderService;

public class OrderListener {

	@Autowired
	OrderService orderService;

	public void orde(Order order) {
		Order o = this.orderService.findById(order.getId());
		if (o != null) {
			o.setStatus(order.getStatus());
			this.orderService.update(o);
		} else {
			System.out.println("ORDER WITH ID = " + order.getId() + " NOT FOUND");
		}

	}
}
