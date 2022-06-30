package com.vrapalis.www.backend.tutorials.security.simplewebapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SimpleWebAppSecurityConfiguration {

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf().ignoringAntMatchers("/h2-console/**")
                .and()
                .formLogin()
                .successForwardUrl("/home")
                .and().headers().frameOptions().sameOrigin()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/access-denied")
                .and()
                .authorizeRequests()
                .mvcMatchers("/products").hasAnyRole("USER")
                .mvcMatchers("/admin-dashboard").hasRole("ADMIN")
                .mvcMatchers("/h2-console/**").permitAll()
                .mvcMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and().build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
