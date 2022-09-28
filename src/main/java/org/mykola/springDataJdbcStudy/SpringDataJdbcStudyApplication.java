package org.mykola.springDataJdbcStudy;

import org.mykola.springDataJdbcStudy.service.DogService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringDataJdbcStudyApplication {

	public static void main(String[] args) {
//		System.out.println("First Spring Started");
		ApplicationContext context = SpringApplication.run(SpringDataJdbcStudyApplication.class, args);
		DogService dogService = context.getBean("dogService", DogService.class);
		dogService.life();
//		System.out.println("Spring Started");
	}

}
