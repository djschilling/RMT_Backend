package com.ratemytree.rmt.user;

/**
 * David Schilling - davejs92@gmail.com
 */
public class UserDTO {

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
