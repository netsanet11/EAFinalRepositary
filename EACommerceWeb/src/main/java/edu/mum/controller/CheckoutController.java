package edu.mum.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.domain.Address;
import edu.mum.domain.Order;
import edu.mum.service.OrderService;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {

	private static final String ORDER = "order";
	@Autowired
	OrderService orderService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String checkoutOrder(@ModelAttribute("newAddress") Address address, Model model,
			HttpServletRequest httpServletRequest) {
		Order order = (Order) httpServletRequest.getSession().getAttribute(ORDER);
		if (order == null) {
			return "welcome";
		}
		model.addAttribute("items", order.getItems());

		return "checkout";

	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String addAddress(Model model, @Valid @ModelAttribute("newAddress") Address address,
			BindingResult bindingResult, HttpServletRequest httpServletRequest) {
		Order order = (Order) httpServletRequest.getSession().getAttribute(ORDER);
		if (order == null) {
			return "welcome";
		}
		order.setAddress(address);
		model.addAttribute("items", order.getItems());
		model.addAttribute("address", order.getAddress());
		return "checkout";

	}

	@RequestMapping(value = "/submit", method = RequestMethod.GET)
	public String submitOrder(Model model, HttpServletRequest httpServletRequest) {
		Order order = (Order) httpServletRequest.getSession().getAttribute(ORDER);

		this.orderService.publishOrder(order);

		httpServletRequest.getSession().removeAttribute(ORDER);
		return "thankyou";

	}

}
