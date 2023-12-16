package com.example1.demo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;

import com.example1.demo2.model.Users;
import com.example1.demo2.repo.UsersRepository;

@Controller
public class IndexController {

    @Autowired
    private UsersRepository usersRepo;

    // @RequestMapping("/example")
    // public String example(){
    //     return "example";
    // }

    // @RequestMapping("/index")
    // public String indexPage(){
    //     return "index";
    // }

    // @RequestMapping("/about")
    // public String aboutPage(){
    //     return "about";
    // }
    
    // @RequestMapping("/products")
    // public String productsPage(){
    //     return "products";
    // }

    @GetMapping("/signup")
    public String signUpPage(){
        return "signup";
    }

    @GetMapping("/thanku")
    public String thankuPage() {
        return "thanku";
    }

    @PostMapping("/register")
    public String userRegistration(Users users) {
        usersRepo.save(users);
        return "redirect:/thanku";
    }


    //Controller for displaying the cart:
    @GetMapping("/cart")
    public String displayCart(){
        return "cart";
    }

}


