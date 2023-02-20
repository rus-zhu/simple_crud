package ru.ruszhu.simple_crud_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ruszhu.simple_crud_app.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
