package co.copper.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableJpaRepositories
@EnableWebMvc
@SpringBootApplication
public class CopperTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CopperTestApplication.class, args);
	}

}
