package com.labmentix;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ELearningPlatformApplication {

	public static void main(String[] args) {

		SpringApplication.run(ELearningPlatformApplication.class, args);

	}

//	@Bean
//	CommandLineRunner initData(QuizRepository repo) {
//		return args -> {
//			repo.save(new Question(null, "What is the capital of France?",
//					"Berlin", "Madrid", "Paris", "Rome", "Paris"));
//
//			repo.save(new Question(null, "Which language runs in a web browser?",
//					"Python", "C++", "Java", "JavaScript", "JavaScript"));
//			repo.save(new Question(null, "Spring Boot is built on top of?",
//					"Spring Framework", "Hibernate", "JPA", "Maven", "Spring Framework"));
//		};
//	}
}
