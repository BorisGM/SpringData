package com.example.exam.model.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginUserBindingModel {

    private String username;
    private String password;


    @Size(min = 3, max = 20, message = "Username length must be between 3 and 10 characters!")
    @NotBlank(message = "Username cannot be empty!")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Size(min = 3, max = 20, message = "Password length must be 3 characters!")
    @NotBlank(message = "Password cannot be empty!")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
