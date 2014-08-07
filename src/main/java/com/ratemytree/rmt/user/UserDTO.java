package com.ratemytree.rmt.user;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * David Schilling - davejs92@gmail.com
 */
public class UserDTO {

    @NotEmpty
    private String username;

    public UserDTO(User user) {
        this.username = user.getUsername();
    }

    public UserDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
