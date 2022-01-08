package com.proiect.cofetarie.model;

import java.util.List;

public class Client {
    private int clientID;
    private String clientName;
    private DeliveryAddress deliveryAddress;
    private String phoneNumber;
    private List<Order> ordersHistory;

    public Client(String clientName, DeliveryAddress deliveryAddress, String phoneNumber, List<Order> ordersHistory) {
        this.clientName = clientName;
        this.deliveryAddress = deliveryAddress;
        this.phoneNumber = phoneNumber;
        this.ordersHistory = ordersHistory;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public DeliveryAddress getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(DeliveryAddress deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Order> getOrdersHistory() {
        return ordersHistory;
    }

    public void setOrdersHistory(List<Order> ordersHistory) {
        this.ordersHistory = ordersHistory;
    }
}
