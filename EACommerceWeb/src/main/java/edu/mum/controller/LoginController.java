package edu.mum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import edu.mum.domain.UserCredential;
import edu.mum.service.UserCredentialsService;

@Controller
@SessionAttributes("user")
public class LoginController {

	@Autowired
	UserCredentialsService credentialsService;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login() {
 		return "login";
	}
 
	
	@RequestMapping(value="/postLogin", method = RequestMethod.POST)
	public String PostLogin(UserCredential credentials, Model model) {
		System.out.println(credentials.getUsername() + credentials.getPassword());
		UserCredential validCredentials = credentialsService.findByUserName(credentials.getUsername());
		System.out.println(validCredentials.getUsername());
		
		if (validCredentials == null)
			return  "login";
 
		System.out.println(validCredentials.getMember().getFirstName());
		model.addAttribute("user", validCredentials.getMember());
 		return "redirect:/welcome";
	}
 
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model) {
 
		model.addAttribute("error", "true");
		return "login";
 
	}
 
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(Model model, SessionStatus status) {
		status.setComplete();
 		return "redirect:/welcome";
 	}
}
