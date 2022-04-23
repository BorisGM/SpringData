package com.example.examprep2.service;

import com.example.examprep2.model.service.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel getByUsername(String username);

    void loginUser(Long id, String username);
}
