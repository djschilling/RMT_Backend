package com.ratemytree.rmt.user;

import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * David Schilling - davejs92@gmail.com
 */
public interface UserService extends UserDetailsService{

    void createUser(String username, String email, String password);
}
