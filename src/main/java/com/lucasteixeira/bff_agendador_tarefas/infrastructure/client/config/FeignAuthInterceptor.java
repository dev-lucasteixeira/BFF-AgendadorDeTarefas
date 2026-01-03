package com.lucasteixeira.bff_agendador_tarefas.infrastructure.client.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Configuration
public class FeignAuthInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        // O RequestContextHolder é o segredo: ele acessa a requisição que chegou no Controller
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        if (attributes != null) {
            String authorizationHeader = attributes.getRequest().getHeader("Authorization");

            if (authorizationHeader != null && !authorizationHeader.isBlank()) {
                // Aqui resolvemos seu problema do "Bearer Bearer" para TODOS os métodos
                String tokenLimpo = authorizationHeader.replace("Bearer ", "").trim();
                template.header("Authorization", "Bearer " + tokenLimpo);
            }
        }
    }
}
