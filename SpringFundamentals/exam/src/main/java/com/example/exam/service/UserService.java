package com.example.exam.service;

import com.example.exam.model.entity.User;
import com.example.exam.model.service.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel getUserByUsernameAndPass(String username,String password);


    boolean existByUserName(String username);

    User findById(Long id);

    void loginUser(Long id, String username);
}
