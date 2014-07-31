package com.ratemytree.rmt.user;

import java.security.Principal;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * David Schilling - davejs92@gmail.com
 */
@Controller
public class AuthenticationController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public HttpEntity<User> login(Principal principal) {

        User userDTO = (User)((UsernamePasswordAuthenticationToken) principal).getPrincipal();
        return new ResponseEntity<>(userDTO, HttpStatus.OK);

    }

}
