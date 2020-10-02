package com.example.quizapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class QuizAppApplication {
	@GetMapping("/show")
	public static void main(String[] args) {
		SpringApplication.run(QuizAppApplication.class, args);
	}

}
