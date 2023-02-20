package ru.ruszhu.simple_crud_app.service.Impl;

import org.springframework.stereotype.Service;
import ru.ruszhu.simple_crud_app.exception.CustomerAlreadyExistsException;
import ru.ruszhu.simple_crud_app.exception.CustomerNotFoundException;
import ru.ruszhu.simple_crud_app.model.Address;
import ru.ruszhu.simple_crud_app.model.Customer;
import ru.ruszhu.simple_crud_app.repository.CustomerRepository;
import ru.ruszhu.simple_crud_app.service.CustomerService;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepo;

    public CustomerServiceImpl(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        List<Customer> customers = customerRepo.findAll();
        if (customers.contains(customer)) {
            throw new CustomerAlreadyExistsException();
        }
        return customerRepo.save(customer);
    }

    @Override
    public Customer findCustomerById(Long id) {
        return customerRepo.findById(id).orElseThrow(CustomerNotFoundException::new);
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public List<Customer> findAllCustomersByAddress(Address address) {
        return customerRepo.findAllByAddress(address);
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerRepo.deleteById(id);
    }
}
