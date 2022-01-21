package com.proiect.cofetarie.exception.client;

public class CityNotFoundInDatabaseException extends RuntimeException {
    public CityNotFoundInDatabaseException(String city) {
        super("Could not found city \"" + city + "\"");
    }
}
