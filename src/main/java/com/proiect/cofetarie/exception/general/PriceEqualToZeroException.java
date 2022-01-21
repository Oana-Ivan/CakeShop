package com.proiect.cofetarie.exception.general;

public class PriceEqualToZeroException extends RuntimeException{
    public PriceEqualToZeroException() {
        super("The price should be grater than zero!");
    }
}
