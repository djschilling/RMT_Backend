package com.ratemytree.rmt.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * David Schilling - davejs92@gmail.com
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("User with username: " + username + " not found");
        }
        return user;
    }

    @Override
    public void createUser(String username, String email, String password) {
        User user = userRepository.findByUsername(username);
        if(user == null) {
            userRepository.save(new User(username, email, password));
        } else {
            throw new UserServiceException("User with name " + username + " already exists.");
        }
    }

    @Override
    public User getCurrentlyLoggedIn() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
