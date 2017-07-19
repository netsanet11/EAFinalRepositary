package edu.mum.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import edu.mum.dao.OrderDao;
import edu.mum.domain.Order;
import edu.mum.domain.User;
import edu.mum.service.OrderService;
import edu.mum.service.UserService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	@Qualifier("directTemplate")
	private RabbitTemplate template;

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private UserService userService;

	@Override
	@Transactional
	public void publishOrder(Order order) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();

		User user = this.userService.findByUsername(name);

		user.getOrders().add(order);
		order.setUser(user);

		this.orderDao.saveFull(order);

		this.template.convertAndSend("fromEAC.key", order);
	}

	@Override
	@Transactional
	public void save(Order order) {
		this.orderDao.saveFull(order);
	}

	@Override
	public List<Order> findAll() {
		return this.orderDao.findAll();
	}
}
