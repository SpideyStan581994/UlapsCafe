package com.ulap.demo.controller;

import com.ulap.demo.model.Coffee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/index","/"})
public class IndexController {

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
        System.out.println(newCoffee);
        return "redirect:/index";
    }
}
