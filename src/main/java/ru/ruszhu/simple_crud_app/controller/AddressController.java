package ru.ruszhu.simple_crud_app.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ruszhu.simple_crud_app.model.Address;
import ru.ruszhu.simple_crud_app.service.Impl.AddressServiceImpl;

@RestController
@RequestMapping("address")
public class AddressController {

    private final AddressServiceImpl addressService;


    public AddressController(AddressServiceImpl addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addAddress(@RequestBody Address address) {
        return new ResponseEntity<>(addressService.addAddress(address),
                HttpStatusCode.valueOf(201));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAddressById(@PathVariable Long id) {
        return ResponseEntity.ok(addressService.findAddressById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllAddresses() {
        return ResponseEntity.ok(addressService.findAllAddress());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAddressById(@PathVariable Long id) {
        return ResponseEntity.ok().body(addressService.findAddressById(id));
    }
}
