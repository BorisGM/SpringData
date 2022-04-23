package com.example.examprep.web;

import com.example.examprep.model.binding.AddOrderBindingModel;
import com.example.examprep.model.service.OrderServiceModel;
import com.example.examprep.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final ModelMapper modelMapper;

    public OrderController(OrderService orderService, ModelMapper modelMapper) {
        this.orderService = orderService;
        this.modelMapper = modelMapper;
    }


    @ModelAttribute
    public AddOrderBindingModel addOrderBindingModel(){
        return new AddOrderBindingModel();
    }

    @GetMapping("/add")
    public String add(Model model){
        if (model.containsAttribute("isExist")){
            model.addAttribute("isExist",true);
        }

        return "order-add";
    }

    @PostMapping("/add")
    public String addOrderConfirm(@Valid AddOrderBindingModel addOrderBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("addOrderBindingModel",addOrderBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.addOrderBindingModel",bindingResult);

            return "redirect:add";
        }

        orderService.addOrder(modelMapper.map(addOrderBindingModel, OrderServiceModel.class));

        return "redirect:/";

    }

    @GetMapping("/ready/{id}")
    public String ready(@PathVariable Long id){
        orderService.readyOrder(id);

        return "redirect:/";
    }
}
