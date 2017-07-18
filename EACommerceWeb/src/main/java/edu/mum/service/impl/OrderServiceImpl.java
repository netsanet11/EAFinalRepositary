package edu.mum.service.impl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.mum.domain.Order;
import edu.mum.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	@Qualifier("directTemplate")
	RabbitTemplate template;

	@Override
	public void publishOrder(Order order) {
		this.template.convertAndSend("fromEAC.key", order);
	}
}
