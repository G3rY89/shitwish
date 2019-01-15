package com.codecool.cartservice.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ElementCollection(targetClass = Integer.class)
    private List<Integer> itemsInCart = new ArrayList<>();
    private boolean isCompleted;
    private int buyerId;

    public Cart(int buyerId){
        this.buyerId = buyerId;
        this.isCompleted = false;
    }

    public Cart() {
    }

    public void addItemToCart(Integer itemId){
        itemsInCart.add(itemId);
    }

    public Integer getId() {
        return id;
    }

    public void removeItem(Integer itemId){
        itemsInCart.remove(itemId);
    }

    public List<Integer> getItemsInCart() {
        return itemsInCart;
    }

    public void changeStatus(){
        this.isCompleted = true;
    }

}
