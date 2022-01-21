package com.proiect.cofetarie.service;

import com.proiect.cofetarie.exception.client.ClientNotFoundException;
import com.proiect.cofetarie.exception.client.CityNotFoundInDatabaseException;
import com.proiect.cofetarie.exception.address.DeliveryAddressNotFound;
import com.proiect.cofetarie.model.Client;
import com.proiect.cofetarie.model.DeliveryAddress;
import com.proiect.cofetarie.repository.ClientRepository;
import com.proiect.cofetarie.repository.DeliveryAddressRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {
    private ClientRepository clientRepository;
    private DeliveryAddressRepository deliveryAddressRepository;

    public ClientService(ClientRepository clientRepository, DeliveryAddressRepository deliveryAddressRepository) {
        this.clientRepository = clientRepository;
        this.deliveryAddressRepository = deliveryAddressRepository;
    }

    public Client save(Client client, int deliveryAddressID) {
        // TODO validate that address exists and order exists
        DeliveryAddress deliveryAddress = deliveryAddressRepository.findById(deliveryAddressID)
                .orElseThrow(() -> new DeliveryAddressNotFound());

        client.setDeliveryAddressID(deliveryAddress);
        return clientRepository.save(client);
    }

    public List<Client> get(String clientName) {
        if (clientName != null) {
            return clientRepository.findByClientName(clientName);
        }
        return clientRepository.findAll();
    }

    public List<Client> getByCity(String city) {
        List<DeliveryAddress> deliveryAddresses = deliveryAddressRepository.findByCity(city);
        if (deliveryAddresses != null) {
            List<Client> clientList = new ArrayList<>();
            for (DeliveryAddress deliveryAddress : deliveryAddresses) {
                Client currentClient = clientRepository.findByDeliveryAddressID(deliveryAddress);
                if (currentClient != null) {
                    clientList.add(currentClient);
                }
            }
            if (!clientList.isEmpty()) {
                return clientList;
            }
        }
        throw new CityNotFoundInDatabaseException(city);
    }

    public Client update(Client client) {
        // TODO validate client

        return clientRepository.save(client);
    }

    public boolean delete(int id) {
        Client client = clientRepository.findById(id).orElse(null);
        if (client == null) {
            throw new ClientNotFoundException(id);
        }
        clientRepository.deleteById(id);
        return true;
    }

}
