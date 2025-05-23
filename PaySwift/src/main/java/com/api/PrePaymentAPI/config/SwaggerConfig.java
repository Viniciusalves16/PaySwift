package com.api.PrePaymentAPI.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Api Swagger Test",
                description = "Projeto exemplo swagger",
                version = "1.0.0",
                contact = @Contact(name = "Vinicius Alves ", email = "vinicius.alves16@outlook.com"),
                license = @License(name = "Apache License Version 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0")
        )
)
public class SwaggerConfig {
    // Configuração adicional do Swagger pode ser feita aqui, se necessário.
}
