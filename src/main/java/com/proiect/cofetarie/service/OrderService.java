package com.proiect.cofetarie.service;

import com.proiect.cofetarie.dto.order.CreateNewOrderDTO;
import com.proiect.cofetarie.dto.order.UpdateOrderDTO;
import com.proiect.cofetarie.exception.category.CakeCategoryNotFoundException;
import com.proiect.cofetarie.exception.client.ClientNotFoundException;
import com.proiect.cofetarie.model.Cake;
import com.proiect.cofetarie.model.Client;
import com.proiect.cofetarie.model.Order;
import com.proiect.cofetarie.repository.CakeRepository;
import com.proiect.cofetarie.repository.ClientRepository;
import com.proiect.cofetarie.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private CakeRepository cakeRepository;
    private ClientRepository clientRepository;
    private CakeService cakeService;

    public OrderService(OrderRepository orderRepository, CakeRepository cakeRepository, ClientRepository clientRepository, CakeService cakeService) {
        this.orderRepository = orderRepository;
        this.cakeRepository = cakeRepository;
        this.clientRepository = clientRepository;
        this.cakeService = cakeService;
    }

    public Order create(CreateNewOrderDTO request) {
        List<Cake> cakes = new ArrayList<>();
        int totalOrderPrice = 0;

        Map<Integer, Integer> cakesIDQuantity = request.getCakesIDList();
        for (Map.Entry<Integer, Integer> cake : cakesIDQuantity.entrySet()) {
            Cake currentCake = cakeRepository.findByCakeID(cake.getKey());
            if (currentCake == null) {
                throw new CakeCategoryNotFoundException(cake.getKey());
            }
            totalOrderPrice += currentCake.getPrice() * cake.getValue();
            cakeService.increasePopularityScoreById(currentCake.getCakeID());
            cakes.add(currentCake);
        }

        Client client = clientRepository.findByClientID(request.getClientID());
        if (client == null) {
            throw new ClientNotFoundException(request.getClientID());
        }

        Order newOrder = new Order(totalOrderPrice, request.getOrderDate(), request.getDeliveryDate(), false, client, cakes);

        return newOrder;
    }

    public Order updateArrived(UpdateOrderDTO request) {
        List<Cake> cakes = new ArrayList<>();

        Map<Integer, Integer> cakesIDQuantity = request.getCakesIDList();
        for (Map.Entry<Integer, Integer> cake : cakesIDQuantity.entrySet()) {
            Cake currentCake = cakeRepository.findByCakeID(cake.getKey());
            if (currentCake == null) {
                throw new CakeCategoryNotFoundException(cake.getKey());
            }
            cakeService.increasePopularityScoreById(currentCake.getCakeID());
            cakes.add(currentCake);
        }

        Client client = clientRepository.findByClientID(request.getClientID());
        if (client == null) {
            throw new ClientNotFoundException(request.getClientID());
        }
        Order order = new Order(request.getOrderID(), request.getTotalPrice(), request.getOrderDate(), request.getDeliveryDate(), true, client, cakes);

        return orderRepository.save(order);
    }

    public List<Order> get() {
        return orderRepository.findAll();
    }
}
