package ru.ruszhu.simple_crud_app.service.Impl;

import org.springframework.stereotype.Service;
import ru.ruszhu.simple_crud_app.exception.AddressAlreadyExistsException;
import ru.ruszhu.simple_crud_app.exception.AddressNotFoundException;
import ru.ruszhu.simple_crud_app.model.Address;
import ru.ruszhu.simple_crud_app.repository.AddressRepository;
import ru.ruszhu.simple_crud_app.service.AddressService;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepo;

    public AddressServiceImpl(AddressRepository addressRepo) {
        this.addressRepo = addressRepo;
    }

    @Override
    public Address addAddress(Address address) {
        List<Address> addresses = addressRepo.findAll();
        if (addresses.contains(address)) {
            throw new AddressAlreadyExistsException();
        }
        return addressRepo.save(address);
    }

    @Override
    public Address findAddressById(Long id) {
        return addressRepo.findById(id).orElseThrow(AddressNotFoundException::new);
    }

    @Override
    public List<Address> findAllAddress() {
        return addressRepo.findAll();
    }

    @Override
    public void deleteAddress(Address address) {
        addressRepo.delete(address);
    }

    @Override
    public void deleteAddressById(Long id) {
        addressRepo.deleteById(id);
    }
}
