package com.ratemytree.rmt.restapi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * Own basic authentication header to prevent Browser from opening a password popup.
 *
 * David Schilling - davejs92@gmail.com
 */
@Component
public class MyBasicAuth extends BasicAuthenticationEntryPoint{

    public MyBasicAuth() {
        this.setRealmName("Rate my tree");
    }

    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {
        response.addHeader("WWW-Authenticate", "xBasic realm=\"" + getRealmName() + "\"");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
    }}
