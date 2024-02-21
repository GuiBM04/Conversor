package com.conversor.api.cors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")  // Mapeie o padrão de URL que deseja permitir
                .allowedOrigins("http://localhost:3000")  // Permita somente a origem específica
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Permita métodos específicos
                .allowedHeaders("Content-Type")  // Permita cabeçalhos específicos
                .allowCredentials(true);  // Permita credenciais (cookies, por exemplo)
    }
}