package edu.mum.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.service.OrderService;

@Controller
@RequestMapping("orders")
public class OrderController {
	@Autowired
	private OrderService orderService;

	@RequestMapping({ "", "/all" })
	public String list(Model model, HttpServletRequest httpServletRequest) {

		model.addAttribute("orders", this.orderService.findAll());
		return "orders";
	}

}
