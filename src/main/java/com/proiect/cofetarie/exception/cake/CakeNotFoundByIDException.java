package com.proiect.cofetarie.exception.cake;

public class CakeNotFoundByIDException extends RuntimeException {
    public CakeNotFoundByIDException(int id) {
        super("Could not found cake with id " + id);
    }
}
