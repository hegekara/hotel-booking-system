package com.hotel.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.hotel"})
@EntityScan(basePackages = {"com.hotel"})
@ComponentScan(basePackages = {"com.hotel"})
@EnableJpaRepositories(basePackages = {"com.hotel"})
public class HotelBookingProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelBookingProjectApplication.class, args);
	}

}
