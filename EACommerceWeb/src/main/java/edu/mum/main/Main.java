package edu.mum.main;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AuthenticationManager;

import edu.mum.domain.UserCredential;
import edu.mum.service.UserCredentialsService;

public class Main {
	@Autowired
	public static UserCredentialsService userCredentialsService;
	
	@Autowired
	public static AuthenticationManager authenticationManager;
	
	public static void main(String[] args) {	
		Authentication authentication = null;
		UserCredential userDetails = userCredentialsService.findByUserName("Paul");
	    Authentication token = new UsernamePasswordAuthenticationToken(userDetails.getUsername(),userDetails.getUsername());
	    try {
	        authentication = authenticationManager.authenticate(token);
	    }
	    catch ( Exception e ) {
	  	  System.out.println(e.getMessage());
	    }
	    
	    SecurityContextHolder.getContext().setAuthentication(authentication);

	}

}
