package com.example.examprep2.web;

import com.example.examprep2.model.enums.CategoryEnum;
import com.example.examprep2.secur.CurrentUser;
import com.example.examprep2.service.ProductService;
import com.example.examprep2.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;


@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final UserService userService;
    private final ProductService productService;
    private final ModelMapper modelMapper;

    public HomeController(CurrentUser currentUser, UserService userService, ProductService productService, ModelMapper modelMapper) {
        this.currentUser = currentUser;
        this.userService = userService;
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public String index(HttpSession httpSession, Model model){

        if (httpSession.getAttribute("user") == null){
            return "index";
        }

//        закачаме атрибут за Цялата сума под това име което закачаме в ХТМЛ като го взимаме от сървиса.
        model.addAttribute("totalSum",productService.getTotalSum());

//        юь view model това са енъми в хтмл под този ключ в ХОМЕ контролер
        model.addAttribute("drinks",productService.findAllProductsByCategoryName(CategoryEnum.DRINK));
        model.addAttribute("food",productService.findAllProductsByCategoryName(CategoryEnum.FOOD));
        model.addAttribute("household",productService.findAllProductsByCategoryName(CategoryEnum.HOUSEHOLD));
        model.addAttribute("other",productService.findAllProductsByCategoryName(CategoryEnum.OTHER));

        return "home";

//        List<OrderViewModel> ordersViewModel = orderService.findAllOrderOrderByPrice();
//
//        model.addAttribute("orders",ordersViewModel);
//        model.addAttribute("totalTime",ordersViewModel
//                .stream()
//                .map(orderViewModel -> orderViewModel.getCategory().getNeededTime())
//                .reduce((a,b) -> a+b)
//                .orElse(0));
//
//        model.addAttribute("users",userService.findAllUsersAndCountOfOrdersOrderByCountDesc());

    }

}
