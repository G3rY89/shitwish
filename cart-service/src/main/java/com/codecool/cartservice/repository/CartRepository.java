package com.codecool.cartservice.repository;

import com.codecool.cartservice.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    @Query(value = "SELECT c from Cart c where c.is_completed = false and c.buyer_id = (:buyerId)", nativeQuery = true)
    Cart findByBuyerId(@Param("buyerId") Integer buyerId);
}
