package edu.mum.transformer;

import edu.mum.domain.Address;
import edu.mum.domain.Order;
import edu.mum.domain.SingleOrder;
import edu.mum.domain.User;
import edu.mum.domain.UserInfo;

public class OrderTransformerImpl implements OrderTransformer {

	public SingleOrder transformToShipment(Order order) {
		SingleOrder singleOrder = new SingleOrder();

		singleOrder.setExternalId(order.getId());
		singleOrder.setQuantity(order.getItems().size());
		UserInfo userInfo = new UserInfo();

		User user = order.getUser();
		userInfo.setUserName(user.getEmail());

		Address address = order.getAddress();
		userInfo.setCity(address.getCity());
		userInfo.setState(address.getState());
		userInfo.setStreet(address.getStreet());
		userInfo.setZipCode(address.getZipCode());

		singleOrder.setUserInfo(userInfo);

		return singleOrder;
	}

	public Order transformToEac(SingleOrder singleOrder) {
		Order order = new Order();

		order.setId(singleOrder.getExternalId());
		return order;
	}

}
