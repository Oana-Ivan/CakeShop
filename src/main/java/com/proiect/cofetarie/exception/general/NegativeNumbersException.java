package com.proiect.cofetarie.exception.general;

public class NegativeNumbersException extends RuntimeException {
    public NegativeNumbersException() {
        super("Negative numbers not allowed.");
    }
}
