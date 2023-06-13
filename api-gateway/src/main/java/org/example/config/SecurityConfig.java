package org.example.config;

import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    JwtAuthenticationConverter jwtAuthenticationConverter(){
        return new JwtAuthenticationConverter();
    }

    @Bean
    @SneakyThrows
    SecurityWebFilterChain securityFilterChain(ServerHttpSecurity http, JwtAuthenticationConverter converter){
        return http.authorizeExchange(auth -> auth
                        .pathMatchers("/eureka/**").permitAll()
                        .anyExchange().authenticated())
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()))
                .build();



    }
}
