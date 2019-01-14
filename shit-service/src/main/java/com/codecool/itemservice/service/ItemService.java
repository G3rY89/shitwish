package com.codecool.itemservice.service;

import com.codecool.itemservice.model.Item;
import com.codecool.itemservice.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getAllAvailableItems() {
        List<Item> availableItems = this.itemRepository.findAllByAvailableTrue();
        return availableItems;
    }

    public void addItem(Item item){
        this.itemRepository.save(item);
    }

    public Optional<Item> findById(long id){
        return this.itemRepository.findById(id);
    }


}
