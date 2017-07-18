package edu.mum.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.domain.SingleOrder;
import edu.mum.service.OrderService;

@Controller
@RequestMapping({"/orders"})
public class OrderController {
	
	@Autowired
	private OrderService  orderService;

	@RequestMapping
	public String listOrders(Model model) {
		model.addAttribute("orders", orderService.findAll());
		return "orders";
	}
	
  	@RequestMapping("/{id}")
	public String getOrderById(@PathVariable("id") Long id,Model model) {
		SingleOrder order = orderService.findOne(id);
		model.addAttribute("order", order);

 		return "order";
	}
	
//	@RequestMapping(value = "/add", method = RequestMethod.GET)
//	public String getAddNewMemberForm(@ModelAttribute("newMember") SingleOrder newMember) {
//	   return "addMember";
//	}
	   
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String processNewShipmentForm( SingleOrder orderToBeUpdate,  Model model) {
 
		System.out.println(orderToBeUpdate.getOrderNumber());
		System.out.println(orderToBeUpdate.getQuantity());
		System.out.println(orderToBeUpdate.getStatus());
		orderService.update(orderToBeUpdate);

		return "redirect:/orders";
 
	}
	
 
}
