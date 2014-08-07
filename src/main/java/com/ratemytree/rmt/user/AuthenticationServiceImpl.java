package com.ratemytree.rmt.user;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * David Schilling - davejs92@gmail.com
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Override
    public User getCurrentlyLoggedIn() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
