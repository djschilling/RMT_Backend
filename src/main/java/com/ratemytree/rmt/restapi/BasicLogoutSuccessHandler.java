package com.ratemytree.rmt.restapi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;


/**
 * @author David Schilling - davejs92@gmail.com
 */
@Component
public class BasicLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
        throws IOException, ServletException {

        response.setHeader("Set-Cookie", "JSESSIONID=deleted;Path=/; expires=Thu, 01 Jan 1970 00:00:00 GMT");
        response.setStatus(200);
    }
}
