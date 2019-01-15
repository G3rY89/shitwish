package com.codecool.itemservice.repository;

import com.codecool.itemservice.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    public List<Item> findAllByAvailableTrue();

}
