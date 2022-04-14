package com.safrizal.foodservice.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "FOODAPP", description = "App makanan", version = "v0.1"))
public class SwaggerConfig {
}
