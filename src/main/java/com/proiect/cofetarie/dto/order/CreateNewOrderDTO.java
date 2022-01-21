package com.proiect.cofetarie.dto.order;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.*;

public class CreateNewOrderDTO {
    private int totalPrice;

    private Date orderDate;

    private Date deliveryDate;

    private Boolean arrived;

    @NotNull
    private int clientID;

    @NotEmpty
    private Map<Integer, Integer> cakesIDList = new HashMap<Integer, Integer>();
//    private List<Integer> cakesIDList = new ArrayList<>();

    public CreateNewOrderDTO() {
    }

    public CreateNewOrderDTO(int totalPrice, Date orderDate, Date deliveryDate, @NotNull int clientID, @NotEmpty Map<Integer, Integer> cakesIDList) {
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.clientID = clientID;
        this.cakesIDList = cakesIDList;
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

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public Map<Integer, Integer> getCakesIDList() {
        return cakesIDList;
    }

    public void setCakesIDList(Map<Integer, Integer> cakesIDList) {
        this.cakesIDList = cakesIDList;
    }
}
