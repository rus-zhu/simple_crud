package ru.ruszhu.simple_crud_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ruszhu.simple_crud_app.model.Address;
import ru.ruszhu.simple_crud_app.model.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findAllByAddress(Address address);
}
