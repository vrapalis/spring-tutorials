package com.vrapalis.www.backendtutorials.security.httpbasic.utils;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SecurityHttpBasicAuthenticationFailureEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.addHeader("CUSTOM-HEADER", "CUSTOM-HEADER-VALUE");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "AUTHENTICATION FAILURE!!!");
    }
}
