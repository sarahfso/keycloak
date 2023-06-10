package com.ufc.backendtestkeycloak.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig {

    private final JwtAuthConverter jwtAuthConverter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        
        return http

        .authorizeHttpRequests((authorizeRequests) ->
            authorizeRequests.requestMatchers("/produtos/**").authenticated()
        )

        .oauth2ResourceServer((oauth2ResourceServer) ->
            oauth2ResourceServer.jwt((jwt) ->
                jwt.jwtAuthenticationConverter(jwtAuthConverter)
            )
        )
        
        .build();
    }

}
