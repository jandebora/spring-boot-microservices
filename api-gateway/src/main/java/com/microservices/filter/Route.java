package com.microservices.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;

@Component
public class Route extends ZuulFilter {
	private static final Logger LOGGER = LoggerFactory.getLogger( Route.class.getName() );
	
	@Override
	public boolean shouldFilter() {
		return true;
	}
	
	@Override
	public String filterType() {
		return "route";
	}
	 
	@Override
	public int filterOrder() {
		return 1;
	}
	 
	@Override
	public Object run() {
		LOGGER.info("Inside Route Filter");
		
		return null;
	}
	  
}
