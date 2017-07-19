package edu.mum.listener;

import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.domain.SingleOrder;
import edu.mum.service.OrderService;

public class OrderListener {

	@Autowired
	private OrderService orderService;

	public void listen(SingleOrder order) {
		this.orderService.save(order);
	}
}
