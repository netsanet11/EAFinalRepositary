package edu.mum.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.domain.SingleOrder;
import edu.mum.service.OrderService;
import edu.mum.service.mail.SendMailExample;

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
	@Autowired
    SendMailExample emailService;
	   
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String processNewShipmentForm( SingleOrder orderToBeUpdate,  Model model) {
 
		System.out.println(order.getStatus().getStr());	
		order.setStatus(orderToBeUpdate.getStatus());

		orderService.update(order);
	    emailService.sendMailWithTemplate(order.getUserInfo().getUserName(), "You are welcome",order.getUserInfo().getEmail());

		return "redirect:/orders";

	}

}
