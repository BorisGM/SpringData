package com.example.exam.model.binding;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Size;

public class RegisterUserBindingModel {

    private String username;
    private String fullName;
    private String email;
    private String password;
    private String confirmPassword;


    @NotBlank(message = "Username can not be empty")
    @Size(min = 3,max = 20,message = "username must be between 3 and 20")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @NotBlank(message = "FullName can not be empty")
    @Size(min = 5,max = 20,message = "Full name must be between 5 and 20")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    @Email(message = "enter valid email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @NotBlank(message = "Password can not be empty")
    @Size(min = 3,message = "password must be 3 symbols")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @NotBlank(message = "Password can not be empty")
    @Size(min = 3,message = "password must be 3 symbols")
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
