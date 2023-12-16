package com.example1.demo2.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example1.demo2.model.Product;
import com.example1.demo2.repo.ProductRepository;

@Controller
public class AddCartController {
    
    @Autowired
    private ProductRepository prodRepo;

    @GetMapping("/addToCart/{id}")
    @ResponseBody
    public Map<String,String> addToCart(@PathVariable("id") Integer productId){
        Map<String,String> response = new HashMap<>();
        Optional<Product>  optional = prodRepo.findById(productId);
        if(optional.isPresent()){
            Product productValues = optional.get();
            response.put("name",productValues.getProductName());
            response.put("image",productValues.getImageURL());
            // I am converting the price of the product to string  then saving it :
            double price = productValues.getProdPrice();
            String convertedPrice = String.valueOf(price); 
            response.put("price",convertedPrice);
            //I am converting the quantity of the product to string  then saving it :
            int quantityInNumber = productValues.getQuantity();
            String convertedQuantity = String.valueOf(quantityInNumber);
            response.put("quantity",convertedQuantity);
        }
        
        return response;
    }
}
