package edu.mum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders")
public class CheckoutController {

	public String checkoutOrder(Model model) {

		return "checkout";

	}

}
