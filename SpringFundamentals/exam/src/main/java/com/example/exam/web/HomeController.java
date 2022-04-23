package com.example.exam.web;

import com.example.exam.service.ShipService;
import com.example.exam.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


@Controller
public class HomeController {

    private final UserService userService;
    private final ShipService service;
    private final ModelMapper  modelMapper;

    public HomeController(UserService userService, ShipService service, ModelMapper modelMapper) {
        this.userService = userService;
        this.service = service;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/")
    public String index(HttpSession httpSession, Model model, ModelAndView modelAndView) {


        if (httpSession.getAttribute("user") == null){
            return "index";
        }
            return "home";


//            model.addAttribute("power",service.getShipPower());
//            model.addAttribute("health",service.getShipHelth());
//            model.addAttribute("name",service.getShipName());
//
//            modelAndView.addObject("ship",service.findAllShips());
//            modelAndView.setViewName("home");
        }



    }

