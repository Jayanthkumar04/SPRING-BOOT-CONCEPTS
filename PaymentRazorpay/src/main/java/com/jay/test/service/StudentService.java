package com.jay.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jay.test.dto.StudentOrder;
import com.jay.test.repo.StudentOrderRepo;
import com.razorpay.RazorpayClient;

@Service
public class StudentService {

	
	@Autowired
	private StudentOrderRepo studentRepo;

	
	@Value("${razorpay.key.id}")
	private String razorpayKey;
	
	@Value("${razorpay.secret.key}")
	private String razorpaySecret;
	
	
	private RazorpayClient client;
	
	public StudentOrder createOrder(StudentOrder order)
	{
		
		//used to create order in razorpay
//		client.orders.create(null);
		
		return new StudentOrder();
	}

}
