package ru.ruszhu.simple_crud_app.exception.handler;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.ruszhu.simple_crud_app.exception.CustomerAlreadyExistsException;

@ControllerAdvice
public class CustomerExceptionHandler {

    @ExceptionHandler(CustomerAlreadyExistsException.class)
    public ResponseEntity<?> handleCustomerAlreadyExistsException(CustomerAlreadyExistsException ex) {
        return new ResponseEntity<>("Customer already exists", HttpStatusCode.valueOf(400));
    }

    @ExceptionHandler(ClassNotFoundException.class)
    public ResponseEntity<?> handleCustomerNotFoundExistsException(ClassNotFoundException ex) {
        return new ResponseEntity<>("Customer not found", HttpStatusCode.valueOf(404));
    }
}
