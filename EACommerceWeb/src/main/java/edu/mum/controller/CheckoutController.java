package edu.mum.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.domain.Order;
import edu.mum.service.OrderService;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {

	private static final String ORDER = "order";
	@Autowired
	OrderService orderService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String checkoutOrder(Model model, HttpServletRequest httpServletRequest) {
		Order order = (Order) httpServletRequest.getSession().getAttribute(ORDER);
		if (order == null) {
			return "welcome";
		}
		model.addAttribute("items", order.getItems());

		return "checkout";

	}

	@RequestMapping(value = "/submit", method = RequestMethod.GET)
	public String submitOrder(Model model, HttpServletRequest httpServletRequest) {
		// User user = (User)
		// httpServletRequest.getSession().getAttribute("testuser");
		Order order = (Order) httpServletRequest.getSession().getAttribute(ORDER);

		this.orderService.publishOrder(order);

		httpServletRequest.getSession().removeAttribute(ORDER);
		return "thankyou";

	}

}
