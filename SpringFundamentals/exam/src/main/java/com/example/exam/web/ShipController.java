package com.example.exam.web;

import com.example.exam.model.binding.AddShipBindingModel;
import com.example.exam.model.service.ShipServiceModel;
import com.example.exam.service.ShipService;
import com.example.exam.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/ships")
public class ShipController {

    private final ModelMapper modelMapper;
    private final UserService userService;
    private final ShipService shipService;


    public ShipController(ModelMapper modelMapper, UserService userService, ShipService shipService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.shipService = shipService;
    }

    @ModelAttribute
    public AddShipBindingModel addOrderBindingModel(){
        return new AddShipBindingModel();
    }


    @GetMapping("/add")
    public String add(Model model){
        if (model.containsAttribute("isExist")){
            model.addAttribute("isExist",true);
        }

        return "ship-add";
    }

    @PostMapping("/add")
    public String addOrderConfirm(@Valid AddShipBindingModel addShipBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes, HttpSession httpSession){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("addShipBindingModel",addShipBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.addShipBindingModel",bindingResult);

            return "redirect:add";
        }

        ShipServiceModel shipServiceModel = modelMapper.map(addShipBindingModel, ShipServiceModel.class);
        shipService.addShip(shipServiceModel);

        return "redirect:/";

    }
}
