package com.codecool.addressService.config;

import com.codecool.addressService.model.Address;
import com.codecool.addressService.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Initialize {

    private AddressService addressService;

    @Autowired
    public Initialize(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostConstruct
    public void initDatabase() throws Exception {
        addressService.addAddress(new Address("Hell street", "12A", "Dark City", 666, "Heaven", "You Know", "Who", 1));
        addressService.addAddress(new Address("Hello street", "100", "Bello City", 43770, "Yooo", "Mario", "Mister", 2));
    }
}
