package edu.mum.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.mum.dao.OrderDao;
import edu.mum.domain.Group;
import edu.mum.domain.Order;
@Repository
public class OrderDaoImpl extends GenericDaoImpl<Order> implements OrderDao {

	public OrderDaoImpl(){
		setDaoType(Order.class);
	}

}
