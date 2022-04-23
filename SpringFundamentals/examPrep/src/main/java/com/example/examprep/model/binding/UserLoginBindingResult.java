package com.example.examprep.model.binding;

import javax.validation.constraints.Size;

public class UserLoginBindingResult {


    private String username;
    private String password;

    @Size(min = 5,max = 20,message = "My username error message.")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Size(min = 3,message = "My password error.")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
