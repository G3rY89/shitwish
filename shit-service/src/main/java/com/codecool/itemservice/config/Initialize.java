package com.codecool.itemservice.config;

import com.codecool.itemservice.model.Item;
import com.codecool.itemservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Initialize {

    private ItemService itemService;

    @Autowired
    public Initialize(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostConstruct
    public void initDatabase() throws Exception {
        itemService.createItem("Stick", "A stick", "https://vignette.wikia.nocookie.net/tokipona/images/a/aa/Stick.png/revision/latest?cb=20171120043817",
                100, 1);
        itemService.createItem("Shit","Piece of shit", "https://http2.mlstatic.com/almofada-emoticon-emoji-cocozinho-pou-grande-40x40-whatsapp-D_NQ_NP_635411-MLB20557478677_012016-F.jpg",
                1500, 2);
        itemService.createItem("Trash", "Everywhere", "https://toppng.com/public/uploads/preview/trash-can-11530995314kgh8pawz8u.png",
                1300, 1);
        itemService.createItem("Wonder Woman","Sexy bitch", "https://www.clipartmax.com/png/middle/195-1951557_wonder-woman-png-edit-justice-league-by-bp251-wonder-woman-gal-gadot.png",
                0, 1);
        itemService.createItem("Little boy", "Yeea boy","https://clipart.info/images/ccovers/1496252513Justin-Bieber-PNG-Picture-2017.png",
                99, 2);
    }
}
