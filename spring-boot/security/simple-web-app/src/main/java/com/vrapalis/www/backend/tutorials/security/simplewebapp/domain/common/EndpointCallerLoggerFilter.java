package com.vrapalis.www.backend.tutorials.security.simplewebapp.domain.common;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@Component
public class EndpointCallerLoggerFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final var authentication = SecurityContextHolder.getContext().getAuthentication();

        log.info("""
                Endpoint url: %s,
                Called by user: %s
                """.formatted(request.getServletPath(), authentication != null ? authentication.getName() : "unauthenticated"));

        filterChain.doFilter(request, response);
    }
}
