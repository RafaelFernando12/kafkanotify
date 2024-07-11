package br.com.bergmann.kafka_api_boleto.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("API boleto")
                .description("API de pagamento de boleto")
                .contact(new Contact().name("Rafael Bergmann").email("rafael.bergmann@hotmail.com"))
                .version("1.0.0")
        );
    }
}
