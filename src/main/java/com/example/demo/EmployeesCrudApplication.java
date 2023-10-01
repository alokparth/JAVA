package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.SpringVersion;

@SpringBootApplication
public class EmployeesCrudApplication {

	public static void main(String[] args) {
//		SpringApplication.run(EmployeesCrudApplication.class, args);
		SpringApplication springApplication=new SpringApplication(EmployeesCrudApplication.class);
	      System.out.println("Spring Core Version:- " + SpringVersion.getVersion());
	      springApplication.run(args);
	}

}
