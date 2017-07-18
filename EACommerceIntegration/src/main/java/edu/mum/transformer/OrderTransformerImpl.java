package edu.mum.transformer;

import edu.mum.domain.Order;
import edu.mum.domain.SingleOrder;

public class OrderTransformerImpl implements OrderTransformer {

	public SingleOrder transformToShipment(Order order) {
		SingleOrder singleOrder = new SingleOrder();

		singleOrder.setProductName(order.getOrderNumber());

		return singleOrder;
	}

	public Order transformToEac(SingleOrder singleOrder) {
		Order order = new Order();
		order.setOrderNumber(singleOrder.getProductName());
		return order;
	}

}
