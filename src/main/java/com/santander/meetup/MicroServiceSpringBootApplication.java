package com.santander.meetup;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication(scanBasePackages = { "com.santander" })


@EnableCaching 
public class MicroServiceSpringBootApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(MicroServiceSpringBootApplication.class, args);
	}

}
