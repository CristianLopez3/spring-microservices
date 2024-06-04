package com.finance.mobileappws.infra;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Micro services",
                        email = "cristian.c.lopez.m@gmail.com",
                        url = "https://github.com/CristianLopez3"
                ),
                description = "Users Module for Micro Services Training",
                title = "Micro Services - Training",
                version = "1.0",
                license = @License(
                        name = "MIT License",
                        url = "https://opensource.org/licenses/MIT"
                ),
                termsOfService = "https://opensource.org/licenses/MIT"
        ),
        servers = {
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8080"
                )
        }
)
public class SwaggerInfo {}