package com.example.examprep2.model.binding;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterUserBindingModel {

    private String username;
    private String email;
    private String password;
    private String confirmPassword;

    @NotNull(message = "Username can not be empty")
    @Size(min = 3,max = 20,message = "Blq blq mejdu 3 i 20")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Email(message = "email muse contains @")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }
    @NotNull(message = "Password can not be empty")
    @Size(min = 3,max = 20,message = "Blq blq message between 3 and 20 symbols")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
