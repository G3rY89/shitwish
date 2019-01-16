package com.codecool.addressService.service;

import com.codecool.addressService.model.Address;
import com.codecool.addressService.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address findAddressByUserId(long userId){
        return addressRepository.findByUserId(userId);
    }

    public void addAddress(Address address){
        this.addressRepository.save(address);
    }

    public List<Address> getAllAddresses(){
        return this.addressRepository.findAll();
    }

    public void deleteAddressBasedOnUserId(long userId){
        this.addressRepository.deleteAddressByUserId(userId);
    }
}
