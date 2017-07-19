package edu.mum.listener;

import edu.mum.domain.SingleOrder;

public class OrderListener {

	public void listen(SingleOrder order) {
		System.out.println("listen!!  " + order.getExternalId());
	}
}
