package com.testing.SpringBootForDeployment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootForDeploymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootForDeploymentApplication.class, args);
		//System.out.println("Deploying springboot with jenkins");
	}

}
