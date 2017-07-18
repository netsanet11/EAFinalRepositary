package edu.mum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.domain.Order;
import edu.mum.service.OrderService;

@Controller
public class HomeController {

	@Autowired
	private OrderService orderService;

	@RequestMapping({ "/", "/welcome" })
	public String welcome(Model model) {

		model.addAttribute("greeting", "EA ONLINE SHOPING !!");
		model.addAttribute("tagline", "where shopping is fun!!");

		return "welcome";
	}

	@RequestMapping("asd")
	public String asd() {
		System.out.println("hey!");
		Order order = new Order();
		order.setId((long) 23);
		this.orderService.publishOrder(order);
		return "welcome";
	}
}
