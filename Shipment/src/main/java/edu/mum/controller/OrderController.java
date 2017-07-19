package edu.mum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.domain.SingleOrder;
import edu.mum.service.OrderService;

@Controller
@RequestMapping({ "/orders" })
public class OrderController {

	@Autowired
	private OrderService  orderService;
	
	private SingleOrder order;

	@RequestMapping
	public String listOrders(Model model) {
		model.addAttribute("orders", this.orderService.findAll());
		return "orders";
	}
	
    @RequestMapping("/{id}")
    public String getOrderById(@PathVariable("id") Long id,Model model) {
        order = orderService.findOne(id);
		model.addAttribute("order", order);
		return "order";
	}
	
	   
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String processNewShipmentForm( SingleOrder orderToBeUpdate,  Model model) {
 
		System.out.println(order.getQuantity());
		System.out.println(order.getStatus());
		System.out.println(order.getUserInfo());
		order.setStatus(orderToBeUpdate.getStatus());
		orderService.update(order);

		return "redirect:/orders";

	}

}
