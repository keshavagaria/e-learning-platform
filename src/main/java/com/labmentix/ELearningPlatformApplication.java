package com.labmentix;


import com.labmentix.entities.RoleType;
import com.labmentix.repository.RoleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ELearningPlatformApplication {


	public static void main(String[] args) {

		SpringApplication.run(ELearningPlatformApplication.class, args);

	}

//	@Bean
//	CommandLineRunner initData(RoleTypeRepository repo) {
//		return args -> {
//			repo.save(new RoleType(1L,"STUDENT"));
//
//			repo.save(new RoleType(2L,"INSTRUCTOR"));
//			repo.save(new RoleType(3L,"ADMIN"));
//		};
//	}
}
