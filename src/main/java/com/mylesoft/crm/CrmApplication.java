package com.mylesoft.crm;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

///@RestController
//@EnableAutoConfiguration


@Configuration
@EnableAutoConfiguration
@ComponentScan
public class CrmApplication {

	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CrmApplication.class, args);
	}

}