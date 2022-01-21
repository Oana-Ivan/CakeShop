package com.proiect.cofetarie.exception;

import com.proiect.cofetarie.exception.address.DeliveryAddressEmptyFieldsException;
import com.proiect.cofetarie.exception.address.DeliveryAddressNotFound;
import com.proiect.cofetarie.exception.cake.CakeAlreadyExistsException;
import com.proiect.cofetarie.exception.cake.CakeNotFoundByIDException;
import com.proiect.cofetarie.exception.category.CakeCategoryNotFoundByNameException;
import com.proiect.cofetarie.exception.category.CakeCategoryNotFoundException;
import com.proiect.cofetarie.exception.client.CityNotFoundInDatabaseException;
import com.proiect.cofetarie.exception.client.ClientNotFoundException;
import com.proiect.cofetarie.exception.general.InvalidUpdateRequestException;
import com.proiect.cofetarie.exception.general.NegativeNumbersException;
import com.proiect.cofetarie.exception.general.PriceEqualToZeroException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({
            CakeAlreadyExistsException.class,
            CakeCategoryNotFoundException.class,
            CakeCategoryNotFoundByNameException.class,
            CakeNotFoundByIDException.class,
            PriceEqualToZeroException.class,
            DeliveryAddressNotFound.class,
            DeliveryAddressEmptyFieldsException.class,
            NegativeNumbersException.class,
            InvalidUpdateRequestException.class,
            ClientNotFoundException.class,
            CityNotFoundInDatabaseException.class})
    public ResponseEntity handle(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
