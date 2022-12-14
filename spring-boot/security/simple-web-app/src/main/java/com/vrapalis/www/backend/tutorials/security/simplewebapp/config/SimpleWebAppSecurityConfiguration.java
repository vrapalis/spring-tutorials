package com.vrapalis.www.backend.tutorials.security.simplewebapp.config;

import com.vrapalis.www.backend.tutorials.security.simplewebapp.domain.common.EndpointCallerLoggerFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SimpleWebAppSecurityConfiguration {

    private final EndpointCallerLoggerFilter endpointCallerLoggerFilter;

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf().ignoringRequestMatchers("/h2-console/**")
                .and()
                .formLogin()
                .defaultSuccessUrl("/home")
                .and().headers().frameOptions().sameOrigin()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/access-denied")
                .and()
                .addFilterAfter(endpointCallerLoggerFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .requestMatchers("/products").hasAnyRole("USER")
                .requestMatchers("/admin-dashboard").hasRole("ADMIN")
                .requestMatchers("/h2-console/**").permitAll()
                .requestMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and().build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
