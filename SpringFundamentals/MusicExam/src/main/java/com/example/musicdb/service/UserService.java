package com.example.musicdb.service;

import com.example.musicdb.model.entity.UserEntity;
import com.example.musicdb.model.service.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    UserEntity findById(Long id);
}
