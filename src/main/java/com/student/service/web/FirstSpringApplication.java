package com.student.service.web;
import com.student.service.web.model.User;
import com.student.service.web.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.math.BigDecimal;

@EnableJpaAuditing
@SpringBootApplication
public class FirstSpringApplication {

	public static void main(String[] args) {

		SpringApplication.run(FirstSpringApplication.class, args);
	}

}