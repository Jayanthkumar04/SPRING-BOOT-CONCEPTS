package com.jay.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.jay.test.entity.Greet;
import com.jay.test.repo.GreetRepo;

@SpringBootTest
@ExtendWith(value= {MockitoExtension.class})
public class UnitTestingServiceTest {

	@MockitoBean
	private GreetRepo greetRepo;
	
	@InjectMocks
	private UnitTestingService service;
	
	
	@Test
	void testAddAddress()
	{
		Greet greet = new Greet("Hello","Birthday");
		
		when(greetRepo.save(greet)).thenReturn(greet);
		
		Greet g = service.addGreet(greet);
		
		assertNotNull(g);
		
		assertEquals(g.getMessage(), greet.getMessage());
		
	}
	
	
	
	
	
	
	
	
}
