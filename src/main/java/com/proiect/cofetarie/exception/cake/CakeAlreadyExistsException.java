package com.proiect.cofetarie.exception.cake;

public class CakeAlreadyExistsException extends RuntimeException{
    public CakeAlreadyExistsException() {
        super("There is already a cake with the same name.");
    }
}
