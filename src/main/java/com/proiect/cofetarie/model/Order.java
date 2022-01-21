package com.proiect.cofetarie.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderID;

    @Column(name = "total_price")
    private int totalPrice;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "delivery_date")
    private Date deliveryDate;

    private Boolean arrived;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToMany(mappedBy = "ordersList")
    private List<Cake> cakesList = new ArrayList<>();

    public void calculateTotalPrice() {
        totalPrice = 0;
        for (Cake product : cakesList) {
            totalPrice += product.getPrice();
        }
    }

    public Order() {

    }

    public Order(int totalPrice, Date orderDate, Date deliveryDate, Boolean arrived, Client client, List<Cake> cakesList) {
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.arrived = arrived;
        this.client = client;
        this.cakesList = cakesList;
    }

    public Order(int orderID, int totalPrice, Date orderDate, Date deliveryDate, Boolean arrived, Client client, List<Cake> cakesList) {
        this.orderID = orderID;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.arrived = arrived;
        this.client = client;
        this.cakesList = cakesList;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Cake> getCakesList() {
        return cakesList;
    }

    public void setCakesList(List<Cake> cakesList) {
        this.cakesList = cakesList;
    }
}
