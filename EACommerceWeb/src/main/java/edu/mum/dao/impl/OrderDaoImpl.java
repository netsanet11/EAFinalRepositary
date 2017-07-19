package edu.mum.dao.impl;

import java.util.Set;

import org.springframework.stereotype.Repository;

import edu.mum.dao.OrderDao;
import edu.mum.domain.Order;
import edu.mum.domain.OrderItem;
import edu.mum.domain.Product;

@Repository
public class OrderDaoImpl extends GenericDaoImpl<Order> implements OrderDao {

	public OrderDaoImpl() {
		setDaoType(Order.class);
	}

	@Override
	public void saveFull(Order order) {
		Set<OrderItem> items = order.getItems();

		for (OrderItem orderItem : items) {
			Product product = this.entityManager.merge(orderItem.getProduct());
			orderItem.setProduct(product);
		}
		this.entityManager.persist(order);
	}

}
