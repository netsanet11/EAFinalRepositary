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
//	protected Map referenceData(HttpServletRequest request) throws Exception {
//
//		Map referenceData = new HashMap();
//
//		Map<String,String> country = new LinkedHashMap<String,String>();
//		country.put("US", "United Stated");
//		country.put("CHINA", "China");
//		country.put("SG", "Singapore");
//		country.put("MY", "Malaysia");
//		referenceData.put("statusList", country);
//		
//		return referenceData;
//	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewMemberForm(@ModelAttribute("newMember") SingleOrder newMember) {
	   return "addMember";
	}
	   
//	@RequestMapping(value = "/add", method = RequestMethod.POST)
//	public String processAddNewMemberForm( @Valid @ModelAttribute("newMember") Order memberToBeAdded, BindingResult result) {
// 
//		if(result.hasErrors()) {
//			return "addMember";
//		}
//
//			 //  Error caught by ControllerAdvice IF no authorization...
//			memberService.saveFull(memberToBeAdded);
//
//	   	return "redirect:/members";
// 
//	}
	
 
}
