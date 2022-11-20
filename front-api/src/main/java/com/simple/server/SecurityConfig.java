package com.simple.server;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // allow all users to access the home pages and the static images directory
                .mvcMatchers("/network").permitAll()
                // all other requests must be authenticated
                .anyRequest().authenticated()
                .and().oauth2Login()
                .and().logout();
        return http.build();
    }
}

