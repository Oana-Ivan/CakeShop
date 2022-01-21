package com.proiect.cofetarie.exception.category;

public class CakeCategoryNotFoundByNameException extends RuntimeException {
    public CakeCategoryNotFoundByNameException(String name) {
        super("Could not found cake category with name " + name);
    }
}
