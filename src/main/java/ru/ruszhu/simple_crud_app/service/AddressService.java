package ru.ruszhu.simple_crud_app.service;

import ru.ruszhu.simple_crud_app.model.Address;

import java.util.List;

public interface AddressService {
    Address addAddress(Address address);

    Address findAddressById(Long id);

    List<Address> findAllAddress();

    void deleteAddress(Address address);

    void deleteAddressById(Long id);
}
