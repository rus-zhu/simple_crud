package ru.ruszhu.simple_crud_app.exception.handler;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.ruszhu.simple_crud_app.exception.AddressAlreadyExistsException;
import ru.ruszhu.simple_crud_app.exception.AddressNotFoundException;

@ControllerAdvice
public class AddressExceptionHandler {

    @ExceptionHandler(AddressAlreadyExistsException.class)
    public ResponseEntity<?> handleAddressAlreadyExistsException(AddressAlreadyExistsException ex) {
        return new ResponseEntity<>("Address already exists", HttpStatusCode.valueOf(400));
    }

    @ExceptionHandler(AddressNotFoundException.class)
    public ResponseEntity<?> handleAddressNotFoundExistsException(AddressNotFoundException ex) {
        return new ResponseEntity<>("Address not found", HttpStatusCode.valueOf(404));
    }
}
