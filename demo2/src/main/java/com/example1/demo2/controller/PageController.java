package com.example1.demo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example1.demo2.model.Users;
import com.example1.demo2.repo.UsersRepository;

@Controller
public class PageController {
    
      @Autowired
     private UsersRepository usersRepo;

    @RequestMapping("/index")
    public String indexPage() {
        return "index";
    }

    @RequestMapping("/about")
    public String aboutPage() {
        return "about";
    }

    // @RequestMapping("/products")
    // public String productsPage() {
    //     return "products";
    // }

    @RequestMapping("/admin")
    public String adminPage(){
        return "adminPage";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @PostMapping("/get-login")
    public String loginSubmit(@RequestParam("email") String email, @RequestParam("password") String password) {
        // Find the person by email ID in the database
        Users person = usersRepo.findByEmail(email);
        
        if (person != null) {
            // Check if the password matches for the admin
            if(person.getEmail().equals("kumarparitosh448@gmail.com") && person.getPassword().equals("123Pari$$")){
                return "redirect:/admin";
            }
            if (person.getEmail().equals(email) && person.getPassword().equals(password)) {
                // Password matches, perform login logic here
                // For example, set the user as authenticated or store user details in session
                
                // Redirect to a success page or homepage
                return "redirect:/index";
            }
            
        }
        
        // If email or password is incorrect, redirect back to the login page with an error message
        return "redirect:/signup";
    }

}
