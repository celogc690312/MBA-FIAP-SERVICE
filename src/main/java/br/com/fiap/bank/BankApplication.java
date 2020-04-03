package br.com.fiap.bank;

import br.com.fiap.bank.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;

@Configuration
@SpringBootApplication
public class BankApplication implements WebMvcConfigurer{

	@Autowired
	private TransactionService transactionService;

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}

	@PostConstruct
	private void populateDatabase() {
		transactionService.populateDatabase();
	}

//	@Override
//	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/**")
//				.allowedOrigins("http://localhost:8100")
//				.allowedMethods("GET");
//	}

}
