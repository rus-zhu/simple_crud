package ru.ruszhu.simple_crud_app.service;

import ru.ruszhu.simple_crud_app.model.Address;
import ru.ruszhu.simple_crud_app.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer addCustomer(Customer customer);

    Customer findCustomerById(Long id);

    List<Customer> findAllCustomers();

    List<Customer> findAllCustomersByAddress(Address address);


    void deleteCustomerById(Long id);
}
