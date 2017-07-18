package edu.mum.transformer;

import edu.mum.domain.Order;
import edu.mum.domain.SingleOrder;

public interface OrderTransformer {
	public SingleOrder transformToShipment(Order order);

	public Order transformToEac(SingleOrder order);
}
