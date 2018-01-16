package com.jm.employees;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeesApplication {

	public static void main(String[] args) {
		System.out.println("Employees start=============");
		SpringApplication.run(EmployeesApplication.class, args);
	}
}
