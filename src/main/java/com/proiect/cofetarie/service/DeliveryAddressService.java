package com.proiect.cofetarie.service;

import com.proiect.cofetarie.exception.general.NegativeNumbersException;
import com.proiect.cofetarie.exception.address.DeliveryAddressEmptyFieldsException;
import com.proiect.cofetarie.exception.address.DeliveryAddressNotFound;
import com.proiect.cofetarie.model.DeliveryAddress;
import com.proiect.cofetarie.repository.DeliveryAddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryAddressService {
    private DeliveryAddressRepository deliveryAddressRepository;

    public DeliveryAddressService(DeliveryAddressRepository deliveryAddressRepository) {
        this.deliveryAddressRepository = deliveryAddressRepository;
    }

    public DeliveryAddress create(DeliveryAddress deliveryAddress) {
        validateDeliveryAddress(deliveryAddress);

        return deliveryAddressRepository.save(deliveryAddress);
    }


    public DeliveryAddress update(DeliveryAddress deliveryAddress) {
        DeliveryAddress existingDeliveryAddress = deliveryAddressRepository.findById(deliveryAddress.getDeliveryAddressID())
                .orElseThrow(() -> new DeliveryAddressNotFound());
        validateDeliveryAddress(deliveryAddress);
        return deliveryAddressRepository.save(deliveryAddress);
    }

    public List<DeliveryAddress> get(String city, String region) {
        if (region != null) {
            if (city != null) {
                return deliveryAddressRepository.findByRegionAndCity(region, city);
            }
            return deliveryAddressRepository.findByRegion(region);
        }
        if (city != null) {
            return deliveryAddressRepository.findByCity(city);
        }
        return deliveryAddressRepository.findAll();
    }

    public boolean delete(int id) {
        DeliveryAddress deliveryAddress = deliveryAddressRepository.findById(id).orElse(null);
        if (deliveryAddress == null) {
            throw new DeliveryAddressNotFound();
        }
        deliveryAddressRepository.deleteById(id);
        return true;
    }

    private void validateDeliveryAddress(DeliveryAddress deliveryAddress) {
        if (deliveryAddress.getCountry().isBlank() ||
            deliveryAddress.getRegion().isBlank() ||
            deliveryAddress.getCity().equals("") ||
            deliveryAddress.getStreet().isBlank()) {
            throw new DeliveryAddressEmptyFieldsException();
        }

        if (deliveryAddress.getStreetNumber() < 0 ||
            deliveryAddress.getFloorNumber() < 0 ||
            deliveryAddress.getApartmentNumber() < 0) {
            throw new NegativeNumbersException();
        }
    }
}
