package com.microservices.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

@Configuration
public class SwaggerConfiguration {

	@Autowired
	private ZuulProperties zuulProperties;
	
	@Bean
	@Primary
	public SwaggerResourcesProvider swaggerResourcesProvider() {
		return () -> {
			List<SwaggerResource> resources = new ArrayList<>();
			zuulProperties.getRoutes().values().stream()
					.forEach(route -> resources.add(createResource(route.getServiceId(), route.getLocation(), "2.0")));
			return resources;
		};
	}
	
	private SwaggerResource createResource(String name, String location, String version) {
		SwaggerResource swaggerResource = new SwaggerResource();
		swaggerResource.setName(name);
		swaggerResource.setLocation("/" + location + "/v2/api-docs");
		swaggerResource.setSwaggerVersion(version);
		System.out.println(name + " " + location +  " " + version + " ");
		return swaggerResource;
	}
}
