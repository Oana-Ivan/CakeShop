package com.proiect.cofetarie.repository;

import com.proiect.cofetarie.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
