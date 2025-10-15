package com.revature.security.java_security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(customizer -> customizer.disable()) // Disable CSRF for simplicity
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/public/**").permitAll() // Public endpoints
                .anyRequest().authenticated() // All other endpoints require authentication
                .formLogin(Customizer.withDefaults()) // Use form-based authentication
                .httpBasic(Customizer.withDefaults())
            ); // Use basic authentication

        return http.build();
    }
}
