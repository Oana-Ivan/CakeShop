package com.proiect.cofetarie.mapper;

import com.proiect.cofetarie.dto.address.CreateNewDeliveryAddressDTO;
import com.proiect.cofetarie.dto.address.UpdateDeliveryAddressDTO;
import com.proiect.cofetarie.model.DeliveryAddress;
import org.springframework.stereotype.Component;

@Component
public class DeliveryAddressMapper {
    public DeliveryAddress create(CreateNewDeliveryAddressDTO request) {
        return new DeliveryAddress(request.getCountry(), request.getRegion(), request.getCity(), request.getStreet(), request.getStreetNumber(), request.getFloorNumber(), request.getApartmentNumber());
    }
    public DeliveryAddress update(UpdateDeliveryAddressDTO request) {
        return new DeliveryAddress(request.getId(), request.getCountry(), request.getRegion(), request.getCity(), request.getStreet(), request.getStreetNumber(), request.getFloorNumber(), request.getApartmentNumber());
    }
}
