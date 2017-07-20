package edu.mum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
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
	private OrderService orderService;
	
	@Autowired
	private SendMailExample emailService;

	private SingleOrder order;

	@RequestMapping
	public String listOrders(Model model) {
		model.addAttribute("orders", this.orderService.findAll());
		return "orders";
	}

	@RequestMapping("/{id}")
	public String getOrderById(@PathVariable("id") Long id, Model model) {
		this.order = this.orderService.findOne(id);
		model.addAttribute("order", this.order);
		return "order";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String processNewShipmentForm(SingleOrder orderToBeUpdate, Model model) {

		System.out.println(this.order.getStatus().getStr());
		this.order.setStatus(orderToBeUpdate.getStatus());

		this.orderService.update(this.order);
		try {
			emailService.sendMailWithTemplate(order.getUserInfo().getUserName(), "You are welcome",order.getUserInfo().getEmail());
		} catch (MailSendException e) {
			e.printStackTrace();
		}
		return "redirect:/orders";

	}

}
