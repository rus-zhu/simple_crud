package ru.ruszhu.simple_crud_app.web.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.ruszhu.simple_crud_app.model.Address;
import ru.ruszhu.simple_crud_app.repository.AddressRepository;
import ru.ruszhu.simple_crud_app.service.AddressService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AddressServiceTest {

    @Autowired
    private AddressService addressService;

    @MockBean
    private AddressRepository addressRepository;

    @Test
    public void test_1() throws Exception {
        Address address1 = Address.builder()
                .id(1L)
                .street("Street")
                .houseNumber("90/1")
                .apartmentNumber(29)
                .build();
        Mockito.when(addressRepository.findById(address1.getId())).thenReturn(Optional.of(address1));
        Address addressById = addressService.findAddressById(address1.getId());
        assertEquals(address1.getStreet(), addressById.getStreet());
    }

}
