package com.example.exam.web;

import com.example.exam.model.binding.LoginUserBindingModel;
import com.example.exam.model.binding.RegisterUserBindingModel;
import com.example.exam.model.service.UserServiceModel;
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
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    public LoginUserBindingModel loginUserBindingModel(){
        return new LoginUserBindingModel();
    }

    @ModelAttribute
    public RegisterUserBindingModel registerUserBindingModel(){
        return new RegisterUserBindingModel();
    }


    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid RegisterUserBindingModel registerUserBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors() ||
                !registerUserBindingModel.getPassword().equals(registerUserBindingModel.getConfirmPassword())
        ||userService.existByUserName(registerUserBindingModel.getUsername())) {

            redirectAttributes.addFlashAttribute("registerUserBindingModel", registerUserBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.registerUserBindingModel",bindingResult);

            return "redirect:register";
        }

        userService.registerUser(modelMapper.map(registerUserBindingModel, UserServiceModel.class));

        return "redirect:login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        if (!model.containsAttribute("isExist")) {
            model.addAttribute("isExist", false);
        }
        return "login";
    }



    @PostMapping("/login")
    public String loginConfirm(@Valid LoginUserBindingModel loginUserBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("loginUserBindingModel", loginUserBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.loginUserBindingModel", bindingResult);

            return "redirect:login";
        }

        UserServiceModel userServiceModel = userService
                .getUserByUsernameAndPass(loginUserBindingModel.getUsername(),loginUserBindingModel.getPassword());

        if (userServiceModel == null) {
            redirectAttributes
                    .addFlashAttribute("loginUserBindingModel", loginUserBindingModel)
                    .addFlashAttribute("isExist", true)
                    .addFlashAttribute("org.springframework.validation.BindingResult.loginUserBindingModel", bindingResult);

            return "redirect:login";
        }

        userService.loginUser(userServiceModel.getId(), loginUserBindingModel.getUsername());
        httpSession.setAttribute("user", userServiceModel);

        return "redirect:/";
    }


    @GetMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();

        return "redirect:/";

    }

}
