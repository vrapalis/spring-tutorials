package com.vrapalis.www.backend.tutorials.security.form.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.time.Instant;
import java.util.Date;

@Configuration
public class SecurityFormConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .formLogin(httpSecurityFormLoginConfigurer -> {
                    httpSecurityFormLoginConfigurer.defaultSuccessUrl("/home", true);
                    httpSecurityFormLoginConfigurer.successHandler((request, response, authentication) -> {
                        System.out.println("AUTHENTICATION SUCCESS: " + authentication.getName());
                        response.sendRedirect("/home");
                    });
                    httpSecurityFormLoginConfigurer.failureHandler((request, response, exception) -> {
                        System.out.println("AUTHENTICATION FAILURE: " + exception.getMessage());
                        response.sendRedirect("/login");
                    });
                })
                .authorizeRequests()
                .requestMatchers("/admin").hasRole("ADMIN")
                .requestMatchers("/home").hasRole("USER")
                .anyRequest().authenticated()
                .and().build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        final var inMemoryUserDetailsManager = new InMemoryUserDetailsManager();

        final var adminUser = User.withUsername("mike").password("123").authorities("ROLE_ADMIN", "ROLE_USER").build();
        final var user = User.withUsername("user").password("123").authorities("ROLE_USER").build();

        inMemoryUserDetailsManager.createUser(adminUser);
        inMemoryUserDetailsManager.createUser(user);

        return inMemoryUserDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
