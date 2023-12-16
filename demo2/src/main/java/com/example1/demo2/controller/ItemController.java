package com.example1.demo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.ResponseBody;

import com.example1.demo2.model.Product;
import com.example1.demo2.repo.ProductRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class ItemController {
    
    @Autowired
    private ProductRepository prodRepo;

    //From here the we can go to the product adding page :
    // Here The Admin Section of Product Adding and Deleting works:
    @GetMapping("/productAdd")
    public String productAddForm(){
        return "productAdding";
    }

    @PostMapping("/addProduct")
    public String productRegister(Product product) {
        prodRepo.save(product);
        return "redirect:/productsPage";
    } 

    @GetMapping("/productsPage")
    public String getProductsPage(Model model){
        List<Product> productsList =  prodRepo.findAll();
        model.addAttribute("productsList", productsList);
         return "productsPage";
    }

    @GetMapping("/products")
    public String productsPage(Model model) {
        List<Product> productsList =  prodRepo.findAll();
        model.addAttribute("productsList", productsList);
        return "products";
    }


    //Understand this code properly:
        @GetMapping("/delete/{id}")
        public String deleteProduct(@PathVariable("id") Integer productId) {
          Optional<Product> productOptional = prodRepo.findById(productId);
            if (productOptional.isPresent()) {
            // Delete the product
            Product product = productOptional.get();
            prodRepo.delete(product);
            }
            else{
                return "redirect:/error";
            }
          return "productsPage";
    }

    //Cdoe for updating the given values:
    @GetMapping("/update/{id}")
    public String updateProduct(@PathVariable("id") Integer productId,Model model){
        Optional<Product> update = prodRepo.findById(productId);

        if(update.isPresent()){
            model.addAttribute("product", update.get());
             return "productUpdating";
        }
        return "redirect:/error";
    }

    @PostMapping("/updateProduct")
    public String productUpdation(@ModelAttribute("product") Product product) {
        prodRepo.save(product);
        return "redirect:/productsPage";
    } 
}
