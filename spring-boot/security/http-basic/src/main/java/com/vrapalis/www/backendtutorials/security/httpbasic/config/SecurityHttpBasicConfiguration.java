package com.vrapalis.www.backendtutorials.security.httpbasic.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityHttpBasicConfiguration {

    private final AuthenticationEntryPoint authenticationEntryPoint;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .httpBasic(httpBasicConfigurer -> {
                    httpBasicConfigurer.authenticationEntryPoint(authenticationEntryPoint);
                })
                .authorizeRequests()
                .requestMatchers("/api/admin").hasRole("ADMIN")
                .requestMatchers("/api/hello").permitAll()
                .anyRequest().authenticated()
                .and().build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        final var inMemoryUserDetailsManager = new InMemoryUserDetailsManager();

        final var adminUser = User.withUsername("mike").password("123").authorities("ROLE_ADMIN").build();
        final var otherUser = User.withUsername("dike").password("123").authorities("ROLE_USER").build();
        inMemoryUserDetailsManager.createUser(adminUser);
        inMemoryUserDetailsManager.createUser(otherUser);

        return inMemoryUserDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
