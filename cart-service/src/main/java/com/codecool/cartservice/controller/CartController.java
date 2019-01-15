package com.codecool.cartservice.controller;

import com.codecool.cartservice.model.Cart;
import com.codecool.cartservice.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
public class CartController {

    private CartRepository cartRepository;
    private Cart cart;

    @Autowired
    public CartController(CartRepository service, Cart cart){
        this.cartRepository = service;
    }

    @PostMapping(value = "/item")
    public void addItem(@RequestParam(value= "buyerId") Integer buyerId, @RequestParam(value = "itemId") Integer itemId){
        if(cartRepository.findByBuyerId(buyerId) != null){
            cart.addItemToCart(itemId);
        } else {
            cart = new Cart(buyerId);
            cart.addItemToCart(itemId);
        }
    }



}
