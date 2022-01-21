package com.proiect.cofetarie.repository;

import com.proiect.cofetarie.model.DeliveryAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryAddressRepository extends JpaRepository<DeliveryAddress, Integer> {
    List<DeliveryAddress> findByRegionAndCity(String region, String city);

    List<DeliveryAddress> findByRegion(String region);

    List<DeliveryAddress> findByCity(String city);
}
