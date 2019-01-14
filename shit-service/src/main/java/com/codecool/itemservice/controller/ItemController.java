package com.codecool.itemservice.controller;


import com.codecool.itemservice.exception.ItemNotFoundException;
import com.codecool.itemservice.model.Item;
import com.codecool.itemservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ItemController {

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/items")
    public List<Item> allAvailableItems(){
        return itemService.getAllAvailableItems();
    }

    @GetMapping("/items/{id}")
    public Item retrieveStudent(@PathVariable long id) {
        Optional<Item> item = this.itemService.findById(id);

        if (!item.isPresent())
            throw new ItemNotFoundException("id-" + id);

        return item.get();
    }

    @PostMapping("/items")
    public void createItem(@RequestBody Item item){
        this.itemService.addItem(item);
    }

    @PutMapping("/items/{id}")
    public ResponseEntity<Object> updateItem(@RequestBody Item item, @PathVariable long id){
        Optional<Item> itemOptional = this.itemService.findById(id);

        if (!itemOptional.isPresent())
            return ResponseEntity.notFound().build();

        item.setId(id);

        this.itemService.addItem(item);
        return ResponseEntity.noContent().build();
    }

}
