package ru.ruszhu.simple_crud_app.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ruszhu.simple_crud_app.model.Customer;
import ru.ruszhu.simple_crud_app.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @PostMapping("/add")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.addCustomer(customer),
                HttpStatusCode.valueOf(201));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.findCustomerById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllCustomers() {
        return ResponseEntity.ok(customerService.findAllCustomers());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok().body(customerService.findCustomerById(id));
    }
}
