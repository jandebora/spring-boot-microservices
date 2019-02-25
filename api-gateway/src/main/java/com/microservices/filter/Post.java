package com.microservices.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

@Component
public class Post extends ZuulFilter {
	
	private static final Logger LOGGER = LoggerFactory.getLogger( Post.class.getName() );

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 1;
	}
	
	@Override
	public Object run() throws ZuulException {
		LOGGER.info("Inside PostFilter");
		
		return null;
	}
}
