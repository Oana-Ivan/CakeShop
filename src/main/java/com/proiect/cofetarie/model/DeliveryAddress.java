package com.proiect.cofetarie.model;

public class DeliveryAddress {
    private int deliveryAddressID;
    private int clientID;
    private String country;
    private String region;
    private String city;
    private String street;
    private int streetNumber;
    private int floorNumber;
    private int apartmentNumber;

    public DeliveryAddress(int clientID, String country, String region, String city, String street, int streetNumber, int floorNumber, int apartmentNumber) {
        this.clientID = clientID;
        this.country = country;
        this.region = region;
        this.city = city;
        this.street = street;
        this.streetNumber = streetNumber;
        this.floorNumber = floorNumber;
        this.apartmentNumber = apartmentNumber;
    }

    public int getDeliveryAddressID() {
        return deliveryAddressID;
    }

    public void setDeliveryAddressID(int deliveryAddressID) {
        this.deliveryAddressID = deliveryAddressID;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }
}
