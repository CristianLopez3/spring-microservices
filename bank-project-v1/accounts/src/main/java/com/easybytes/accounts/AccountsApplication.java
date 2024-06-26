package com.easybytes.accounts;

import com.easybytes.accounts.dto.AccountsContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;



@EnableConfigurationProperties(value = {AccountsContactInfoDto.class})
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Account microservice REST API documentation",
				description = "EazyBank Account microservice REST API documentation",
				version = "1.0",
				contact = @Contact(
						name = "Cristian Lopez",
						email = "cristian.c.lopez.m@gmail.com",
						url = "https://github.com/CristianLopez3"
				),
				license = @License(
						name = "Apache 2.0",
						url = "http://www.apache.org/licenses/LICENSE-2.0.html"
				)
		),
		externalDocs = @ExternalDocumentation (
				description = "EazyBank Account microservice documentation",
				url = "https://github.com/CristianLopez3"
		)
)
public class  AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
