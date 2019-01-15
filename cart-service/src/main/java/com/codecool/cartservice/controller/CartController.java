package com.codecool.cartservice.controller;

import com.codecool.cartservice.model.Cart;
import com.codecool.cartservice.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    private CartRepository cartRepository;
    private Cart cart;
    private int cartId;

    @Autowired
    public CartController(CartRepository service, Cart cart){
        this.cartRepository = service;
    }

    @PostMapping(value = "/itemToCart")
    public void addItem(@RequestParam(value= "buyerId") Integer buyerId, @RequestParam(value = "itemId") Integer itemId){
        if (cartRepository.findByBuyerIdAndIdAndIsCompleted(buyerId, cartId, false) != null){
            cart = cartRepository.findByBuyerIdAndIdAndIsCompleted(buyerId, cartId, false);
            cart.addItemToCart(itemId);
            cartRepository.save(cart);
        } else {
            cart = new Cart(buyerId);
            cart.addItemToCart(itemId);
            cartRepository.save(cart);
            cartId = cart.getId();
        }
    }

    @RequestMapping(value = "/removeItem", method = RequestMethod.DELETE)
    public void deleteItem(@RequestParam("buyerId") Integer buyerId, @RequestParam("itemId") Integer itemId){
        if(cartRepository.findByBuyerIdAndIdAndIsCompleted(buyerId, cartId, false) != null){
            cart = cartRepository.findByBuyerIdAndIdAndIsCompleted(buyerId, cartId, false);
            cart.removeItem(itemId);
            cartRepository.save(cart);
        } else {
            return;
        }
    }

    @RequestMapping(value = "/payment_successful", method = RequestMethod.PUT)
    public List<Integer> paymentSuccessful(@RequestParam("buyerId") Integer buyerId){
        cart = cartRepository.findByBuyerId(buyerId);
        cart.changeStatus();
        cartRepository.save(cart);
    return cartRepository.findByBuyerId(buyerId).getItemsInCart();
    }

    @GetMapping(value = "/cartitems")
    public String getItemsInCart(@RequestParam("buyerId") Integer buyerId) {
        if (cartRepository.findByBuyerIdAndIsCompleted(buyerId, false) == null){
            return "empty";
        } else {
            return cartRepository.findByBuyerIdAndIsCompleted(buyerId, false).getItemsInCart().toString();
        }
    }
}
