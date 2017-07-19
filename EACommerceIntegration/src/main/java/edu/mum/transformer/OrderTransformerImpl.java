package edu.mum.transformer;

import edu.mum.domain.Address;
import edu.mum.domain.Order;
import edu.mum.domain.OrderStatus;
import edu.mum.domain.SingleOrder;
import edu.mum.domain.SingleStatus;
import edu.mum.domain.User;
import edu.mum.domain.UserInfo;

public class OrderTransformerImpl implements OrderTransformer {

	public SingleOrder transformToShipment(Order order) {
		SingleOrder singleOrder = new SingleOrder();

		singleOrder.setExternalId(order.getId());
		singleOrder.setQuantity(order.getItems().size());
		UserInfo userInfo = new UserInfo();

		User user = order.getUser();
		if (user != null) {
			userInfo.setUserName(user.getUserCredentials().getUsername());
			userInfo.setEmail(user.getEmail());
		}

		Address address = order.getAddress();
		if (address != null) {
			userInfo.setCity(address.getCity());
			userInfo.setState(address.getState());
			userInfo.setStreet(address.getStreet());
			userInfo.setZipCode(address.getZipCode());
		}
		singleOrder.setStatus(translateToShipment(order.getStatus()));

		singleOrder.setUserInfo(userInfo);

		return singleOrder;
	}

	private SingleStatus translateToShipment(OrderStatus status) {

		switch (status) {
		case INTR:
			return SingleStatus.INTRANSIT;

		case DELIV:
			return SingleStatus.DELIVERED;

		case UNDELIV:
			return SingleStatus.UNDELIVEDED;

		case PREP:
			return SingleStatus.PREPARING;
		}
		return null;
	}

	public Order transformToEac(SingleOrder singleOrder) {
		Order order = new Order();

		order.setId(singleOrder.getExternalId());
		order.setStatus(transformToEAC(singleOrder.getStatus()));
		return order;
	}

	private OrderStatus transformToEAC(SingleStatus status) {
		switch (status) {
		case INTRANSIT:
			return OrderStatus.INTR;

		case DELIVERED:
			return OrderStatus.DELIV;

		case UNDELIVEDED:
			return OrderStatus.UNDELIV;

		case PREPARING:
			return OrderStatus.PREP;
		}
		return null;
	}

}
