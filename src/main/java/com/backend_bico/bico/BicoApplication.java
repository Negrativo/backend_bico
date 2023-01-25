package com.backend_bico.bico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableCaching
@SpringBootApplication
@ComponentScan(basePackages = {"br.com.myorg"})
@EnableJpaRepositories(basePackages = {"br.com.myorg"})
@EntityScan(basePackages = {"br.com.myorg"})
public class BicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BicoApplication.class, args);
	}

}
