package com.jay.test.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jay.test.entity.Greet;
import com.jay.test.service.UnitTestingService;

@RestController
@RequestMapping("/api")
public class GreetController {

	private final UnitTestingService service;
	
	public GreetController(UnitTestingService service) {
	
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<Greet> addGreet(@RequestBody Greet body)
	{
		
		Greet greet = service.addGreet(body);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(greet);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Greet> getGreetById(@PathVariable("id") UUID id)
	{
		Greet greet = service.getGreetById(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(greet);		
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Greet>> getAll()
	{
		List<Greet> greet = service.getAllGreets();
		
		return ResponseEntity.status(HttpStatus.OK).body(greet);		
		
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Greet> updateGreet(@RequestBody Greet body,@PathVariable UUID id)
	{
		Greet greet = service.updateGreet(body,id);
		
		return ResponseEntity.status(HttpStatus.OK).body(greet);		
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteGreet(@PathVariable("id") UUID id)
	{
		service.deleteGreet(id);
		
		return ResponseEntity.status(HttpStatus.OK).body("deleted successfully");		
		
	}
	
	
}
