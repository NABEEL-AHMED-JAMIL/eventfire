package com.admaxim.eventfire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@ComponentScan(basePackages = "com.admaxim.eventfire")
public class EventfireApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventfireApplication.class, args);
	}
}
