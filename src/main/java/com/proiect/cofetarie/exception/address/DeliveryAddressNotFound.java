package com.proiect.cofetarie.exception.address;

public class DeliveryAddressNotFound extends RuntimeException{
    public DeliveryAddressNotFound() {
        super("Delivery address not found");
    }
}
