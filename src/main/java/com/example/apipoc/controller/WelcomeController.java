package com.example.apipoc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@RequestMapping("/counter")
	public String greeting() {
		return "Welcome to my counterApp";
	}

}
