package com.proiect.cofetarie.repository;

import com.proiect.cofetarie.model.Client;
import com.proiect.cofetarie.model.DeliveryAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    List<Client> findByClientName(String clientName);
    Client findByDeliveryAddressID(DeliveryAddress deliveryAddressID);

    Client findByClientID(int clientID);
}
