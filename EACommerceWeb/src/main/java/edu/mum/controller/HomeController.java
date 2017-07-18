package edu.mum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
  
@Controller
public class HomeController {

 
	@RequestMapping({"/","/welcome"})
	public String welcome(Model model) {
		
		model.addAttribute("greeting", "EA ONLINE SHOPING !!");
		model.addAttribute("tagline", "where shopping is fun!!");
		
		return "welcome";
	}
 
}
