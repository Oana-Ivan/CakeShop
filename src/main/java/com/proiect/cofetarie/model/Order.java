package com.proiect.cofetarie.model;

import java.util.Date;
import java.util.Map;

public class Order {
    private int orderID;
    private int clientID;
    // List: <cake, quantity>
    private Map<Cake, Integer> productsList;
    private Date orderDate;
    private Date deliveryDate;
    private Boolean arrived;

    public Order(int clientID, Map<Cake, Integer> productsList, Date orderDate, Date deliveryDate) {
        this.clientID = clientID;
        this.productsList = productsList;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.arrived = false;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public Map<Cake, Integer> getProductsList() {
        return productsList;
    }

    public void setProductsList(Map<Cake, Integer> productsList) {
        this.productsList = productsList;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Boolean getArrived() {
        return arrived;
    }

    public void setArrived(Boolean arrived) {
        this.arrived = arrived;
    }
}
