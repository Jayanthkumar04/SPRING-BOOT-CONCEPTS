package com.jay.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jay.test.dto.StudentOrder;
import com.jay.test.service.StudentService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	
	@PostMapping("/create-order")
	
	ResponseEntity<StudentOrder> createOrder(@RequestBody StudentOrder order) throws Exception
	{
		
		StudentOrder dto = studentService.createOrder(order);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(dto);
		
	}
}
