package com.revature.project_p2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectP2Application {

	public static void main(String[] args) {
		System.out.println(System.getenv("springdoc.api-docs.path"));
		System.out.println(System.getenv("spring.datasource.url"));
		SpringApplication.run(ProjectP2Application.class, args);
	}

}
