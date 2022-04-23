package com.example.examprep2.model.binding;

import javax.validation.constraints.Size;

public class LoginUserBindingModel {

    private String username;
    private String password;

    @Size(min = 3,max = 20,message = "Incorrect username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {

        this.username = username;
    }
    @Size(min = 3,max = 20,message = "Incorrect Password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
