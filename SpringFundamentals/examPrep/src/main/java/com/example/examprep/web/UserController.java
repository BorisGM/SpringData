package com.example.examprep.web;

import com.example.examprep.model.binding.UserLoginBindingResult;
import com.example.examprep.model.binding.UserRegistrationBindingModel;
import com.example.examprep.model.service.UserServiceModel;
import com.example.examprep.service.UserService;
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
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegistrationBindingModel userRegistrationBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors() ||
                !userRegistrationBindingModel.getPassword().equals(userRegistrationBindingModel.getConfirmPassword())
                || userService.existByUserName(userRegistrationBindingModel.getUsername())) {

            redirectAttributes.addFlashAttribute("userRegistrationBindingModel", userRegistrationBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegistrationBindingModel");

            return "redirect:register";
        }
        userService.registerUser(modelMapper.map(userRegistrationBindingModel, UserServiceModel.class));

        return "redirect:login";
    }


    @GetMapping("/login")
    public String login(Model model) {
        if (!model.containsAttribute("isExist")) {
            model.addAttribute("isExist", true);
        }
        return "login";
    }

    @PostMapping("/login")
    public String loginConfirm(@Valid UserLoginBindingResult userLoginBindingResult,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginBindingResult", userLoginBindingResult)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingResult", bindingResult);

            return "redirect:login";
        }

        UserServiceModel userServiceModel = userService
                .findByUsernameAndPassword(userLoginBindingResult.getUsername());

        if (userServiceModel == null) {
            redirectAttributes
                    .addFlashAttribute("userLoginBindingResult", userLoginBindingResult)
                    .addFlashAttribute("isExist", false);

            return "redirect:login";
        }

        userService.loginUser(userServiceModel.getId(), userLoginBindingResult.getUsername());

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();

        return "redirect:/";

    }

    @ModelAttribute
    public UserRegistrationBindingModel userRegistrationBindingModel() {
        return new UserRegistrationBindingModel();
    }

    @ModelAttribute
    public UserLoginBindingResult userLoginBindingResult() {
        return new UserLoginBindingResult();
    }
}
