package com.soundmonster.soundmonster_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SoundmonsterBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoundmonsterBackendApplication.class, args);
		System.out.println("\uD83C\uDFB6Soundmonster Backend Application Start");
	}

}
