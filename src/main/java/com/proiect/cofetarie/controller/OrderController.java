package com.proiect.cofetarie.controller;

import com.proiect.cofetarie.dto.address.CreateNewDeliveryAddressDTO;
import com.proiect.cofetarie.dto.address.UpdateDeliveryAddressDTO;
import com.proiect.cofetarie.dto.order.CreateNewOrderDTO;
import com.proiect.cofetarie.dto.order.UpdateOrderDTO;
import com.proiect.cofetarie.exception.general.InvalidUpdateRequestException;
import com.proiect.cofetarie.mapper.OrderMapper;
import com.proiect.cofetarie.model.DeliveryAddress;
import com.proiect.cofetarie.model.Order;
import com.proiect.cofetarie.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/order")
@Validated
public class OrderController {
    private OrderService orderService;
    private OrderMapper orderMapper;

    public OrderController(OrderService orderService, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    @PostMapping("/new")
    public ResponseEntity<Order> create(
            @Valid
            @RequestBody CreateNewOrderDTO request) {
        Order order = orderService.create(request);
        return ResponseEntity.created(URI.create("/order/new" + order.getOrderID())).body(order);
    }

    @PatchMapping( "arrived/{id}")
    public ResponseEntity<Order> updateArrived(
            @PathVariable long id,
            @Valid
            @RequestBody UpdateOrderDTO request
    ) {

        if (id != request.getOrderID()) {
            throw new InvalidUpdateRequestException();
        }

        return ResponseEntity.ok(orderService.updateArrived(request));
    }

    @GetMapping("all-orders")
    public List<Order> get() {
        return orderService.get();
    }
}
