package com.jay.test.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.jay.test.entity.Greet;
import com.jay.test.service.UnitTestingService;

import tools.jackson.databind.ObjectMapper;


@WebMvcTest(controllers = GreetController.class)
public class GreetControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockitoBean
	private UnitTestingService service;
	
	
	@Test
	public void testGetAllGreets() throws Exception{
		
		Greet g1 = new Greet();
		Greet g2 = new Greet();
		
		List<Greet> greets = new ArrayList<>();
		greets.add(g1);greets.add(g2);
  		
		when(service.getAllGreets()).thenReturn(greets);
		
		
	//Prepare Get Request	
	MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/api/all");
	
//	Send Get Request
	MvcResult result = mockMvc.perform(req).andReturn();
	
//	Get response from request and validate it
	MockHttpServletResponse response = result.getResponse();
	
	int status = response.getStatus();
	
	assertEquals(200, status);
	
	
	}
	
	
	@Test
	public void testSaveGreet() throws Exception
	{
		
		Greet g1 = new Greet();
		g1.setId(UUID.fromString("7225b8cd-df26-4229-9149-e6411ac19c54"));
		g1.setMessage("hello");
		g1.setOccasion("just hello");
		
		when(service.addGreet(any(Greet.class))).thenReturn(g1);
		
		ObjectMapper mapper = new ObjectMapper();
		
		String customJson = mapper.writeValueAsString(g1);
		
		MockHttpServletRequestBuilder req = MockMvcRequestBuilders.post("/api")
																  .contentType("application/json")
																  .content(customJson);
		
		     MvcResult result =  mockMvc.perform(req).andReturn();
		     
		     MockHttpServletResponse response = result.getResponse();
		     
		     String contentAsString = response.getContentAsString();
		
		     assertEquals(customJson, contentAsString);
		     
		     assertEquals(201,response.getStatus());
		     
		     
	}
	
	@Test
	public void testDeleteGreet() throws Exception
	{
		
		UUID id = UUID.fromString("7225b8cd-df26-4229-9149-e6411ac19c54");
		
	    doNothing().when(service).deleteGreet(id);

	    MockHttpServletRequestBuilder req = MockMvcRequestBuilders.delete("/api/{id}",id);
	    
	    MvcResult result = mockMvc.perform(req).andReturn();

	    MockHttpServletResponse response = result.getResponse();

	    assertEquals(200, response.getStatus());
	    
	    assertEquals("deleted successfully", response.getContentAsString());
		
	}
	
	@Test
	public void testGetGreetById() throws Exception
	{
		UUID id = UUID.fromString("7225b8cd-df26-4229-9149-e6411ac19c54");
		Greet g1 = new Greet();
		g1.setId(id); g1.setMessage("hello");g1.setOccasion("HELLO OCC");
	    
		when(service.getGreetById(any(UUID.class))).thenReturn(g1);
		
		MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/api/{id}",id);
		
		MvcResult result = mockMvc.perform(req).andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		
		assertEquals(200,response.getStatus());
		
		
		
	}
	
	@Test
	public void testUpdateGreet() throws Exception
	{
		UUID id = UUID.fromString("7225b8cd-df26-4229-9149-e6411ac19c54");
		Greet g1 = new Greet();
		g1.setId(id); g1.setMessage("hello");g1.setOccasion("HELLO OCC");
	    
		when(service.updateGreet(any(Greet.class), any(UUID.class))).thenReturn(g1);
		
		ObjectMapper mapper = new ObjectMapper();
		
		String customJson = mapper.writeValueAsString(g1);
		
		MockHttpServletRequestBuilder req = MockMvcRequestBuilders.patch("/api/{id}",id)
																  .contentType("application/json")
																  .content(customJson);
		
		     MvcResult result =  mockMvc.perform(req).andReturn();
		     
		     MockHttpServletResponse response = result.getResponse();
		     
		     int status = response.getStatus();
		     
		     assertEquals(200,status);
		
		
		
	}
	
	
	

	
}
