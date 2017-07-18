package edu.mum.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.domain.UserCredentials;
import edu.mum.service.UserCredentialsService;
  
@Controller
public class HomeController {

	@Autowired
	UserCredentialsService credentialsService;
 
//	@RequestMapping({"/","/login"})
//	public String login(Model model) {
//		
//		model.addAttribute("greeting", "Welcome to our community, Kimosabe!!");
//		model.addAttribute("tagline", "The one and only place to live, work and play!!");
//		
//		return "login";
//	}
	@RequestMapping(value= {"/","/login"}, method = RequestMethod.GET)
	public String login() {
 		return "login";
	}
 

	@RequestMapping(value="/postLogin", method = RequestMethod.POST)
	public String PostLogin(UserCredentials credentials, Model model) {
		System.out.println("I amd in PostLogin");
		UserCredentials validCredentials = credentialsService.findByUserName(credentials.getUsername());
 
		if (validCredentials == null)
			return  "login";
 
//		model.addAttribute("member", validCredentials.getMember());
 		return "redirect:/orders";
	}	
 
}
