package br.com.ecosage;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@OpenAPIDefinition(
		info = @Info(
				title = "EcoSage API - Java",
				version = "1.0",
				description = "API for EcoSage application - System about personal Energy management and how to save it.",
				contact = @Contact(
						name = "Igor Luiz",
						email = "rm99809@fiap.com.br",
						url = "https://github.com/IgorLuiz777/EcoSageAPI-java"
				),
				license = @License(
						name = "Source Code",
						url = "https://github.com/IgorLuiz777/EcoSageAPI-java"
				)
		)
)
@SpringBootApplication
@RestController("/")
public class EcoSageApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcoSageApplication.class, args);
	}

	@GetMapping()
	public String hello() {
		return "EcoSage API - JAVA";
	}
}
