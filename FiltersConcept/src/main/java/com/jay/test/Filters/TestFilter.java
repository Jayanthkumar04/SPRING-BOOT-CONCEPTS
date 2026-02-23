package com.jay.test.Filters;

import java.io.IOException;

import org.springframework.context.annotation.Configuration;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

@Configuration
public class TestFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("this is filter called , called even before the service api is called");
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		
		System.out.println("request url "+httpServletRequest.getRequestURI());
		
		chain.doFilter(httpServletRequest, response);
		
	}

	
}
