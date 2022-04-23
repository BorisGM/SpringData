package com.example.examprep.service;

import com.example.examprep.model.entity.User;
import com.example.examprep.model.service.UserServiceModel;
import com.example.examprep.model.view.UserViewModel;

import java.util.List;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);
     boolean existByUserName(String username);

    UserServiceModel findByUsernameAndPassword(String username);

    void loginUser(Long id, String username);


    User findById(Long id);

    List<UserViewModel> findAllUsersAndCountOfOrdersOrderByCountDesc();
}
