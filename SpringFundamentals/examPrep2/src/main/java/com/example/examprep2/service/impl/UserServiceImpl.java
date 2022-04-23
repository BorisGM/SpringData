package com.example.examprep2.service.impl;


import com.example.examprep2.model.entity.User;
import com.example.examprep2.model.service.UserServiceModel;
import com.example.examprep2.repository.UserRepository;
import com.example.examprep2.secur.CurrentUser;
import com.example.examprep2.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        User user = modelMapper.map(userServiceModel,User.class);
        userRepository.save(user);
    }

    @Override
    public UserServiceModel getByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(user -> modelMapper.map(user,UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void loginUser(Long id, String username) {
        currentUser.setId(id);
        currentUser.setUsername(username);
    }
}
