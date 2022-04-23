package com.example.exam.service.impl;

import com.example.exam.model.entity.Ship;
import com.example.exam.model.service.ShipServiceModel;
import com.example.exam.model.view.ShipViewModel;
import com.example.exam.repository.ShipRepository;
import com.example.exam.sec.CurrentUser;
import com.example.exam.service.CategoryService;
import com.example.exam.service.ShipService;
import com.example.exam.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShipServiceImpl implements ShipService {
    private final ShipRepository shipRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CategoryService categoryService;
    private final CurrentUser currentUser;



    public ShipServiceImpl(ShipRepository shipRepository, ModelMapper modelMapper, UserService userService, CategoryService categoryService, CurrentUser currentUser) {
        this.shipRepository = shipRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.categoryService = categoryService;
        this.currentUser = currentUser;
    }

    @Override
    public void addShip(ShipServiceModel shipServiceModel) {

        Ship ship = modelMapper.map(shipServiceModel, Ship.class);
        ship.setUser(userService.findById(currentUser.getId()));
        ship.setCategory(categoryService.findByCategoryNameEnum(shipServiceModel.getCategory()));
        shipRepository.save(ship);
    }

    @Override
    public List<ShipViewModel> findAllShips() {
        return this.shipRepository.findAll()
                .stream()
                .map(ship -> {
                    ShipViewModel shipViewModel = modelMapper.map(ship,ShipViewModel.class);

                    return  shipViewModel;
                }).collect(Collectors.toList());
    }

    @Override
    public Long getShipPower() {
       return shipRepository.getPower();
    }

    @Override
    public Long getShipHelth() {
        return shipRepository.getHealth();
    }

    @Override
    public String getShipName() {

        return shipRepository.getName();
    }
}
