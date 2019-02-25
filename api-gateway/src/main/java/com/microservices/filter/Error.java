package com.microservices.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

@Component
public class Error extends ZuulFilter {
	
	private static final Logger LOGGER = LoggerFactory.getLogger( Error.class.getName() );

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public String filterType() {
		return "error";
	}

	@Override
	public int filterOrder() {
		return 1;
	}
	
	@Override
	public Object run() throws ZuulException {
		LOGGER.info("Inside ErrorFilter");
		
		return null;
	}
}
