package com.proiect.cofetarie.service;

import com.proiect.cofetarie.model.Client;
import com.proiect.cofetarie.model.DeliveryAddress;
import com.proiect.cofetarie.repository.ClientRepository;
import com.proiect.cofetarie.repository.DeliveryAddressRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {
    @Mock
    private ClientRepository clientRepository;
    @Mock
    private DeliveryAddressRepository deliveryAddressRepository;
    @InjectMocks
    private ClientService clientService;

    @Test
    void save() {
        // arrange
        DeliveryAddress deliveryAddress = new DeliveryAddress("Romania", "Bucharest", "Bucharest", "Iuliu Maniu", 5, 8, 89);
        Client client = new Client("Andrei", "0764522377");
        Mockito.when(clientRepository.save(client)).thenReturn(client);

        // act
        Client result = clientRepository.save(client);

        // assert
        assertNotNull(result);
        Mockito.verify(clientRepository).save(client);
    }

    @Test
    void get() {
    }

    @Test
    void getByCity() {
    }

    @Test
    void update() {
    }
}