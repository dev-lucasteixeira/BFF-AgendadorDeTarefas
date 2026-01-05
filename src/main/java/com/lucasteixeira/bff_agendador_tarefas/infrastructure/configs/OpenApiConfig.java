package com.lucasteixeira.bff_agendador_tarefas.infrastructure.configs;

import com.lucasteixeira.bff_agendador_tarefas.infrastructure.security.SecurityConfig;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement()
                        .addList(SecurityConfig.SECURITY_SCHEME));
    }
}
