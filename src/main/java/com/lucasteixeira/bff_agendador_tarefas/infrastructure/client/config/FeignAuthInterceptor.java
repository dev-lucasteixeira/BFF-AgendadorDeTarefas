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
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            String authorizationHeader = attributes.getRequest().getHeader("Authorization");

            // Só aplica se o header existir e não for nulo/vazio
            if (authorizationHeader != null && !authorizationHeader.isBlank()) {
                String tokenLimpo = authorizationHeader.replace("Bearer", "").trim();
                template.header("Authorization", "Bearer " + tokenLimpo);
            }
        }
    }
}
