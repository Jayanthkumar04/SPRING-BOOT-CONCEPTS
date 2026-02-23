package com.jay.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController {

	
	@GetMapping("/getText")
	public String getText()
	{
	   System.out.println("controller method");
		return "i am cmng";
	}
}
