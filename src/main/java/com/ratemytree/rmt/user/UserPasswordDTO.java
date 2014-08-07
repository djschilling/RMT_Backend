package com.ratemytree.rmt.user;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * David Schilling - davejs92@gmail.com
 */
public class UserPasswordDTO extends UserDTO{

    @NotEmpty
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
