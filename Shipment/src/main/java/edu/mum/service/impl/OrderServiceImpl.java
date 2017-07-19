package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.OrderDao;
import edu.mum.domain.SingleOrder;
import edu.mum.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;

	@Override
	public void save(SingleOrder order) {
		this.orderDao.save(order);
	}

	@Override
	public void update(SingleOrder singleOrder) {
		this.orderDao.update(singleOrder);
		return;
	}

	@Override
	public List<SingleOrder> findAll() {
		return this.orderDao.findAll();
	}

	@Override
	public SingleOrder findOne(Long id) {
		return this.orderDao.findOne(id);
	}

}
