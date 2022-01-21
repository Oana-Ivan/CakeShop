package com.proiect.cofetarie.service;

import com.proiect.cofetarie.exception.address.DeliveryAddressEmptyFieldsException;
import com.proiect.cofetarie.exception.address.DeliveryAddressNotFound;
import com.proiect.cofetarie.exception.general.NegativeNumbersException;
import com.proiect.cofetarie.model.DeliveryAddress;
import com.proiect.cofetarie.repository.DeliveryAddressRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.never;

@ExtendWith(MockitoExtension.class)
class DeliveryAddressServiceTest {
    @Mock
    private DeliveryAddressRepository deliveryAddressRepository;
    @InjectMocks
    private DeliveryAddressService deliveryAddressService;


    @Test
    @DisplayName("created successfully")
    void create() {
        // arrange
        DeliveryAddress deliveryAddress = new DeliveryAddress("Romania", "Bucharest", "Bucharest", "Iuliu Maniu", 5, 8, 89);
        Mockito.when(deliveryAddressRepository.save(deliveryAddress)).thenReturn(deliveryAddress);

        // act
        DeliveryAddress result = deliveryAddressService.create(deliveryAddress);

        // assert
        assertNotNull(result);
        Mockito.verify(deliveryAddressRepository).save(deliveryAddress);
    }

    @Test
    @DisplayName("Throws DeliveryAddressEmptyFieldsException")
    void createThrowsDeliveryAddressEmptyFieldsException() {
        // arrange
        DeliveryAddress deliveryAddress = new DeliveryAddress("", "", "Bucharest", "Iuliu Maniu", 5, 8, 89);

        // act
        DeliveryAddressEmptyFieldsException exception = assertThrows(DeliveryAddressEmptyFieldsException.class,
                () -> deliveryAddressService.create(deliveryAddress));

        // assert
        assertNotNull(exception);
        assertEquals("Fields must not be empty.", exception.getMessage());
        Mockito.verify(deliveryAddressRepository, never()).save(deliveryAddress);
    }

    @Test
    @DisplayName("Throws NegativeNumbersException")
    void createThrowsNegativeNumbersException() {
        // arrange
        DeliveryAddress deliveryAddress = new DeliveryAddress("Romania", "Bucharest", "Bucharest", "Iuliu Maniu", -5, 8, -89);

        // act
        NegativeNumbersException exception = assertThrows(NegativeNumbersException.class,
                () -> deliveryAddressService.create(deliveryAddress));

        // assert
        assertNotNull(exception);
        assertEquals("Negative numbers not allowed.", exception.getMessage());
        Mockito.verify(deliveryAddressRepository, never()).save(deliveryAddress);
    }

    @Test
    @DisplayName("updated successfully")
    void update() {
        // arrange
        DeliveryAddress deliveryAddress = new DeliveryAddress("Romania", "Bucharest", "Bucharest", "Iuliu Maniu", 5, 8, 89);
        Mockito.when(deliveryAddressRepository.findById(deliveryAddress.getDeliveryAddressID())).thenReturn(java.util.Optional.of(deliveryAddress));
        Mockito.when(deliveryAddressService.update(deliveryAddress)).thenReturn(deliveryAddress);

        // act
        DeliveryAddress result = deliveryAddressService.update(deliveryAddress);

        // assert
        assertNotNull(result);
        Mockito.verify(deliveryAddressRepository).save(deliveryAddress);
    }
    @Test
    @DisplayName("Throws DeliveryAddressNotFound")
    void updateThrowsDeliveryAddressNotFound() {
        // arrange
        DeliveryAddress deliveryAddress = new DeliveryAddress("Romania", "Bucharest", "Bucharest", "Iuliu Maniu", 5, 8, 89);
        Mockito.when(deliveryAddressRepository.findById(deliveryAddress.getDeliveryAddressID())).thenReturn(Optional.empty());

        // act
        DeliveryAddressNotFound exception = assertThrows(DeliveryAddressNotFound.class,
                () -> deliveryAddressService.update(deliveryAddress));

        // assert
        assertNotNull(exception);
        assertEquals("Delivery address not found", exception.getMessage());
        Mockito.verify(deliveryAddressRepository, never()).save(deliveryAddress);
    }

    @Test
    @DisplayName("get successful by city")
    void getByCity() {
        //arrange
        String city = "Bucharest";
        DeliveryAddress deliveryAddress = new DeliveryAddress("Romania", "Bucharest", "Bucharest", "Iuliu Maniu", 5, 8, 89);
        Mockito.when(deliveryAddressRepository.findByCity(city))
                .thenReturn(List.of(deliveryAddress));

        //act
        List<DeliveryAddress> result = deliveryAddressService.get(city, null);

        //assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(deliveryAddress, result.get(0));

        Mockito.verify(deliveryAddressRepository).findByCity(city);
        Mockito.verify(deliveryAddressRepository, never()).findByRegionAndCity(Mockito.any(), Mockito.any());
        Mockito.verify(deliveryAddressRepository, never()).findByRegion(Mockito.any());
        Mockito.verify(deliveryAddressRepository, never()).findAll();
    }

    @Test
    @DisplayName("get successful by region")
    void getByRegion() {
        //arrange
        String region = "Bucharest";
        DeliveryAddress deliveryAddress = new DeliveryAddress("Romania", "Bucharest", "Bucharest", "Iuliu Maniu", 5, 8, 89);
        Mockito.when(deliveryAddressRepository.findByRegion(region))
                .thenReturn(List.of(deliveryAddress));

        //act
        List<DeliveryAddress> result = deliveryAddressService.get(null, region);

        //assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(deliveryAddress, result.get(0));

        Mockito.verify(deliveryAddressRepository).findByRegion(region);
        Mockito.verify(deliveryAddressRepository, never()).findByRegionAndCity(Mockito.any(), Mockito.any());
        Mockito.verify(deliveryAddressRepository, never()).findByCity(Mockito.any());
        Mockito.verify(deliveryAddressRepository, never()).findAll();
    }
    @Test
    @DisplayName("Get by region and city")
    void getByRegionAndCity() {
        //arrange
        String region = "Bucharest";
        String city = "Bucharest";
        DeliveryAddress deliveryAddress = new DeliveryAddress("Romania", "Bucharest", "Bucharest", "Iuliu Maniu", 5, 8, 89);
        Mockito.when(deliveryAddressRepository.findByRegionAndCity(region, city))
                .thenReturn(List.of(deliveryAddress));

        //act
        List<DeliveryAddress> result = deliveryAddressService.get(city, region);

        //assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(deliveryAddress, result.get(0));

        Mockito.verify(deliveryAddressRepository, never()).findByRegion(Mockito.any());
        Mockito.verify(deliveryAddressRepository).findByRegionAndCity(region, city);
        Mockito.verify(deliveryAddressRepository, never()).findByCity(Mockito.any());
        Mockito.verify(deliveryAddressRepository, never()).findAll();
    }

    @Test
    @DisplayName("Get all drivers - no filters by name and city")
    void getAll() {
        //arrange
        DeliveryAddress deliveryAddress = new DeliveryAddress("Romania", "Bucharest", "Bucharest", "Iuliu Maniu", 5, 8, 89);
        Mockito.when(deliveryAddressRepository.findAll()).thenReturn(List.of(deliveryAddress));

        //act
        List<DeliveryAddress> result = deliveryAddressService.get(null, null);

        //assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(deliveryAddress, result.get(0));

        Mockito.verify(deliveryAddressRepository, never()).findByRegion(Mockito.any());
        Mockito.verify(deliveryAddressRepository, never()).findByRegionAndCity(Mockito.any(), Mockito.any());
        Mockito.verify(deliveryAddressRepository, never()).findByCity(Mockito.any());
        Mockito.verify(deliveryAddressRepository).findAll();
    }

    @Test
    @DisplayName("delete successfully")
    void delete() {
        // arrange
        int id = 1;
        DeliveryAddress deliveryAddress = new DeliveryAddress("Romania", "Bucharest", "Bucharest", "Iuliu Maniu", 5, 8, 89);
        Mockito.when(deliveryAddressRepository.findById(id)).thenReturn(Optional.of(deliveryAddress));

        // act
        boolean result = deliveryAddressService.delete(id);

        // assert
        assertTrue(result);
        Mockito.verify(deliveryAddressRepository).deleteById(id);
    }

    @Test
    @DisplayName("delete throws DeliveryAddressNotFound")
    void deleteThrowsDeliveryAddressNotFound() {
        // arrange
        int id = 1;
        DeliveryAddress deliveryAddress = new DeliveryAddress("Romania", "Bucharest", "Bucharest", "Iuliu Maniu", 5, 8, 89);
        Mockito.when(deliveryAddressRepository.findById(id)).thenReturn(Optional.empty());

        // act
        DeliveryAddressNotFound exception = assertThrows(DeliveryAddressNotFound.class,
                () -> deliveryAddressService.delete(id));

        // assert
        assertNotNull(exception);
        assertEquals("Delivery address not found", exception.getMessage());
        Mockito.verify(deliveryAddressRepository, never()).deleteById(id);
    }
}