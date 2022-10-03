package com.catscompany.catscompany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class CatscompanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatscompanyApplication.class, args);
	}

}
