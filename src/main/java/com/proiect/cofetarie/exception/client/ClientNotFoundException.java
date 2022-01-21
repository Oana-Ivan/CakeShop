package com.proiect.cofetarie.exception.client;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(int id) {
        super("Could not found client with id: " + id);
    }
}
