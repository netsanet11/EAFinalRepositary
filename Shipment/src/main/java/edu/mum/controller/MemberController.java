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
import edu.mum.service.MemberService;

@Controller
@RequestMapping({"/orders"})
public class MemberController {
	
	@Autowired
	private MemberService  memberService;

	@RequestMapping
	public String listMembers(Model model) {
		model.addAttribute("orders", memberService.findAll());
		return "orders";
	}
	
  	@RequestMapping("/{id}")
	public String getMemberById(@PathVariable("id") Long id,Model model) {
		SingleOrder order = memberService.findOne(id);
		model.addAttribute("order", order);

 		return "order";
	}
	
//	@RequestMapping(value = "/add", method = RequestMethod.GET)
//	public String getAddNewMemberForm(@ModelAttribute("newMember") SingleOrder newMember) {
//	   return "addMember";
//	}
	   
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String processNewShipmentForm( @Valid @ModelAttribute("newShipment") SingleOrder orderToBeUpdate, BindingResult result) {
 
		if(result.hasErrors()) {
			return "order";
		}
		System.out.println("orderToBeUpdate :" + orderToBeUpdate.getStatus());

			 //  Error caught by ControllerAdvice IF no authorization...
		//	memberService.saveFull(memberToBeAdded);

	   	return "orders";
 
	}
	
 
}
