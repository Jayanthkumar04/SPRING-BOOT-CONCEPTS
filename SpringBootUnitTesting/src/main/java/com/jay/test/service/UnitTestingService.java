package com.jay.test.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jay.test.entity.Greet;
import com.jay.test.repo.GreetRepo;

@Service
public class UnitTestingService {

	
//	@Autowired
	private final GreetRepo greetRepo;
	
	public UnitTestingService(GreetRepo greetRepo) {
	
		this.greetRepo = greetRepo;
	}
	
	public Greet addGreet(Greet greet)
	{
		Greet greets = greetRepo.save(greet);
		
		return greets;
	}
	
	public Greet getGreetById(UUID id)
	{
		
		Greet greet = greetRepo.findById(id).orElseThrow(()->new RuntimeException("greet not found"));
		
		return greet;
		
	}
	
	public List<Greet> getAllGreets()
	{
		return greetRepo.findAll();
	}
	
	
	public Greet updateGreet(Greet greet,UUID id)
	{
		Greet g = getGreetById(id);
		
		if(greet.getMessage() != null) g.setMessage(greet.getMessage());
		
		if(greet.getOccasion() != null) g.setOccasion(greet.getOccasion());
		
		return greetRepo.save(g);
	}
	
	
	public void deleteGreet(UUID id)
	{
		getGreetById(id);
		
		greetRepo.deleteById(id);
		
	}
	
	
}
