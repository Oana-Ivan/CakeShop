package com.proiect.cofetarie.exception.cake;

public class CakeNotFoundException extends RuntimeException {
    public CakeNotFoundException(String name) {
        super("Could not found cake with name " + name);
    }
}
