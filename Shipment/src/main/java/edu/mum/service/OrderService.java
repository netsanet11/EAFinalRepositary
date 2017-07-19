package edu.mum.service;

import java.util.List;

import edu.mum.domain.SingleOrder;

public interface OrderService {

	public void update(SingleOrder singleOrder);

	public List<SingleOrder> findAll();

	public SingleOrder findOne(Long id);

	public void save(SingleOrder order);

}
