package com.example.examprep.web;

import com.example.examprep.model.view.OrderViewModel;
import com.example.examprep.sec.CurrentUser;
import com.example.examprep.service.OrderService;
import com.example.examprep.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final UserService userService;
    private final OrderService orderService;

    public HomeController(CurrentUser currentUser, OrderService orderService, UserService userService) {
        this.currentUser = currentUser;
        this.orderService = orderService;
        this.userService = userService;
    }


    @GetMapping()
    public String index(Model model) {

        if (currentUser.getId() == null) {
            return "index";
        }

        List<OrderViewModel> ordersViewModel = orderService.findAllOrderOrderByPrice();

        model.addAttribute("orders",ordersViewModel);
        model.addAttribute("totalTime",ordersViewModel
                .stream()
                .map(orderViewModel -> orderViewModel.getCategory().getNeededTime())
                .reduce((a,b) -> a+b)
                .orElse(0));

        model.addAttribute("users",userService.findAllUsersAndCountOfOrdersOrderByCountDesc());

        return "home";

    }
}
