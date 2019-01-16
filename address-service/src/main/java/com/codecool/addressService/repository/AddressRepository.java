package com.codecool.addressService.repository;

import com.codecool.addressService.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface AddressRepository extends JpaRepository<Address, Long> {
    public Address findByUserId(@Param("userId") long id);

    public void deleteAddressByUserId(@Param("userId") long id);
}
