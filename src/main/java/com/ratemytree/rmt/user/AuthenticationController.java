package com.ratemytree.rmt.user;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * David Schilling - davejs92@gmail.com
 */
@Controller
public class AuthenticationController {

    private final UserService userService;

    @Autowired
    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public HttpEntity<User> login(Principal principal) {

        User userDTO = (User)((UsernamePasswordAuthenticationToken) principal).getPrincipal();
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public HttpEntity createUser(@RequestBody User user) {
        userService.createUser(user.getUsername(), user.getPassword());
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
