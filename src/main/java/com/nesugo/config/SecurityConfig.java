package com.nesugo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // フロントがSPAならCSRFは一旦無効でも可
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll() // すべてのリクエストを許可
            );
        return http.build();
    }
}
