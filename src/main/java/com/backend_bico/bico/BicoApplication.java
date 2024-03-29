package com.backend_bico.bico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableCaching
@SpringBootApplication(scanBasePackages = { "com", "com.backend_bico" })
@EnableJpaRepositories(basePackages = {"com.backend_bico.bico"})
@EntityScan(basePackages = {"com.backend_bico.bico"})
public class BicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BicoApplication.class, args);
	}

}
