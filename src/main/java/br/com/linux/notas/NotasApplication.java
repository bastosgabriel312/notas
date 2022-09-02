package br.com.linux.notas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class NotasApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotasApplication.class, args);

	}

}
