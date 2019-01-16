package com.codecool.cartservice.repository;

import com.codecool.cartservice.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    Cart findByBuyerIdAndIdAndIsCompleted(Integer buyerId, Integer cartId, boolean completed);
    Cart findByBuyerId(Integer buyerId);
    Cart findByBuyerIdAndIsCompleted(Integer buyerId, boolean completed);
}
