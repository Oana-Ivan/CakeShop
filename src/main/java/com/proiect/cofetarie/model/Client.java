package com.proiect.cofetarie.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private int clientID;

    @Column(name = "client_name")
    private String clientName;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "delivery_address_id")
    private DeliveryAddress deliveryAddressID;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<Order> ordersHistory = new ArrayList<>();

    public Client(String clientName, DeliveryAddress deliveryAddress, String phoneNumber, List<Order> ordersHistory) {
        this.clientName = clientName;
        this.deliveryAddressID = deliveryAddress;
        this.phoneNumber = phoneNumber;
//        this.ordersHistory = ordersHistory;
    }

    public Client(String clientName, String phoneNumber) {
        this.clientName = clientName;
        this.phoneNumber = phoneNumber;
    }

    public Client() {

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

    public DeliveryAddress getDeliveryAddressID() {
        return deliveryAddressID;
    }

    public void setDeliveryAddressID(DeliveryAddress deliveryAddress) {
        this.deliveryAddressID = deliveryAddress;
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
