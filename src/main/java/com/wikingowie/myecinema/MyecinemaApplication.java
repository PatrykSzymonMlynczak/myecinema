package com.wikingowie.myecinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MyecinemaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyecinemaApplication.class, args);
	}

}
