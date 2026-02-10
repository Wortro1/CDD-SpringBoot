package com.CDD.GYM.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI customerOpenApi() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Casa Del Deporte")
                        .version("1.0.0"));
    }
}
