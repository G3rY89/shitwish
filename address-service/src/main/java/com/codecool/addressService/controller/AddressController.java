package com.codecool.addressService.controller;

import com.codecool.addressService.model.Address;
import com.codecool.addressService.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/address")
    public List<Address> retrieveAllAddresses(){
        return addressService.getAllAddresses();
    }

    @GetMapping("/address/{id}")
    public Address retrieveAddressByUserId(@PathVariable long userId) {
        Address address = this.addressService.findAddressByUserId(userId);

        return address;
    }

    @PostMapping("/address")
    public void addAddress(@RequestBody Address address){
        this.addressService.addAddress(address);
    }

    @PutMapping("/address/{id}")
    public void updateAddressByUserId(@PathVariable long userId, @RequestBody Address newAddress){
        Address oldAddress = this.addressService.findAddressByUserId(userId);
        oldAddress.setCity(newAddress.getCity());
        oldAddress.setStreet(newAddress.getStreet());
        oldAddress.setHouseNumber(newAddress.getHouseNumber());
        oldAddress.setZipCode(newAddress.getZipCode());
        oldAddress.setCountry(newAddress.getCountry());
        oldAddress.setFirstName(newAddress.getFirstName());
        oldAddress.setLastName(newAddress.getLastName());

        this.addressService.addAddress(oldAddress);
    }

}
