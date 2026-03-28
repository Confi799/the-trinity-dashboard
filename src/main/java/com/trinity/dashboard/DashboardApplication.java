package com.trinity.dashboard;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;

@SpringBootApplication
public class DashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(DashboardApplication.class, args);
	}

	@Bean
	CommandLineRunner init(CompetidorRepository repo) {
		return args -> {
			if (repo.count() == 0) {
				List.of("Fabricio", "Brandon", "Antonio").forEach(nombre -> {
					Competidor c = new Competidor();
					c.setNombre(nombre);
					repo.save(c);
				});
				System.out.println(">>> 3 Competidores creados en la base de datos.");
			}
		};
	}
}