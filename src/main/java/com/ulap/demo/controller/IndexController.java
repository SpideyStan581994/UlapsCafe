package com.ulap.demo.controller;

import com.ulap.demo.model.Coffee;
import com.ulap.demo.services.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/index","/"})
public class IndexController {

    private final CoffeeService coffeeService;

    @Autowired
    public IndexController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @GetMapping
    public String showIndex(){
        return "index";
    }

    @GetMapping("/addCoffee")
    public String addCoffee(Model model){
        Coffee myCoffee = new Coffee();
        model.addAttribute("coffee",myCoffee);
        return "addCoffee";
    }


    @PostMapping("/addNewCoffee")
    public String addNewCoffee(@ModelAttribute Coffee newCoffee){
        coffeeService.addCoffee(newCoffee);
        return "redirect:/index";
    }
}
