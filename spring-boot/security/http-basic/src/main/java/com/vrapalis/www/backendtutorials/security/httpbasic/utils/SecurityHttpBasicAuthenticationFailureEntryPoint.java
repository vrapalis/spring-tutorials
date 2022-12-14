package com.vrapalis.www.backendtutorials.security.httpbasic.utils;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SecurityHttpBasicAuthenticationFailureEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.addHeader("CUSTOM-HEADER", "CUSTOM-HEADER-VALUE");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "AUTHENTICATION FAILURE!!!");
    }
}
