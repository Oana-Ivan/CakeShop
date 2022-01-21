package com.proiect.cofetarie.exception.category;

public class CakeCategoryNotFoundException extends RuntimeException {
    public CakeCategoryNotFoundException(int id) {
        super("Could not found cake category with id " + id);
    }
}
