package com.training.autoVendor.exception;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AutoVendorExceptionHandler {

    @Autowired
    private AutoVendorException autoVendorException;

    @ExceptionHandler(value = {AutoVendorNotFoundException.class})
    public ResponseEntity<Object> handleAutoVendorNOtFoundException(AutoVendorNotFoundException autoVendorNotFoundException){

        this.autoVendorException.setMessage(autoVendorNotFoundException.getMessage());
        this.autoVendorException.setHttpStatus(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(autoVendorException, HttpStatus.NOT_FOUND);
    }
}
