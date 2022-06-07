package com.example.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication application = new SpringApplication(ApiApplication.class);
	    Map<String, Object> map = new HashMap<String,Object>();
	    map.put("server.servlet.context-path", "/v1");
	    map.put("server.port", "8081");
	    application.setDefaultProperties(map);
	    application.run(args);
	}
}
