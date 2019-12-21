package com.springboot.cashAdvance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringbootServicioCashAdvanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioCashAdvanceApplication.class, args);
	}

}
