package com.proiect.cofetarie.dto.order;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Map;

public class UpdateOrderDTO extends CreateNewOrderDTO {
    @NotNull
    private int orderID;

    public UpdateOrderDTO(int totalPrice, Date orderDate, Date deliveryDate, @NotNull int clientID, @NotEmpty Map<Integer, Integer> cakesIDList, @NotNull int orderID) {
        super(totalPrice, orderDate, deliveryDate, clientID, cakesIDList);
        this.orderID = orderID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
}
