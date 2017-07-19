package edu.mum.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.domain.Order;
import edu.mum.domain.User;
import edu.mum.service.OrderService;

@Controller
@RequestMapping("/orders")
public class CheckoutController {

	@Autowired
	OrderService orderService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String checkoutOrder(Model model, HttpServletRequest httpServletRequest) {
		User user = (User) httpServletRequest.getSession().getAttribute("testuser");
		// model.addAttribute("items", user.getOrders().get(0).getItems());
		System.out.println(user.getOrders().size());
		return "checkout";

	}

	@RequestMapping(value = "/submit", method = RequestMethod.GET)
	public String submitOrder(Model model, HttpServletRequest httpServletRequest) {
		User user = (User) httpServletRequest.getSession().getAttribute("testuser");
		Order order = (Order) httpServletRequest.getSession().getAttribute("order");
		orderService.publishOrder(order);
		return "thankyou";

	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String orderList(Model model, HttpServletRequest httpServletRequest) {
		User user = (User) httpServletRequest.getSession().getAttribute("testuser");
		Order order = (Order) httpServletRequest.getSession().getAttribute("order");
		orderService.publishOrder(order);
		return "thankyou";

	}

}
