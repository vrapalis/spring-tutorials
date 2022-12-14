package com.vrapalis.www.backend.tutorials.security.simplewebapp.domain.common;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Log4j2
@Component
public class EndpointCallerLoggerFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        final var authentication = SecurityContextHolder.getContext().getAuthentication();

        log.info("""
                Endpoint url: %s,
                Called by user: %s
                """.formatted(request.getServletPath(), authentication != null ? authentication.getName() : "unauthenticated"));

        filterChain.doFilter(request, response);
    }
}
