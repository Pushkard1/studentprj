package com.example.StudentPrj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentPrj.entities.AuthRequest;
import com.example.StudentPrj.util.jwtutil;

@RestController
public class jwtcontroller {

	@Autowired
	private jwtutil jwtutil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
	
//	try {	
//		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
//	}catch(Exception ex) {
//		throw new Exception("Invalid username/password");
//	}
	return jwtutil.generateToken(authRequest.getUserName());
	
		
	}
}
