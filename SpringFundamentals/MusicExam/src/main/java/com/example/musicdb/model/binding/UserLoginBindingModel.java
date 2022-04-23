package com.example.musicdb.model.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserLoginBindingModel {
    private String username;
    private String password;

    public UserLoginBindingModel() {
    }

    @Size(min = 3, max = 20, message = "Username length must be between 3 and 20 characters!")
    @NotBlank(message = "Username cannot be empty!")
    public String getUsername() {
        return username;
    }

    public UserLoginBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    @Size(min = 5, max = 20, message = "Password length must be between 5 and 20 characters!")
    @NotBlank(message = "Password cannot be empty!")
    public String getPassword() {
        return password;
    }

    public UserLoginBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
