package com.proiect.cofetarie.exception.address;

public class DeliveryAddressEmptyFieldsException extends RuntimeException {
    public DeliveryAddressEmptyFieldsException() {
        super("Fields must not be empty.");
    }
}
