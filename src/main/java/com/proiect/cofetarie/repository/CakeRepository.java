package com.proiect.cofetarie.repository;

import com.proiect.cofetarie.model.Cake;
import com.proiect.cofetarie.model.CakeCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CakeRepository extends JpaRepository<Cake, Integer> {
    Optional<Cake> findByCakeName(String name);

    List<Cake> findByPriceLessThanAndWeightLessThan(int price, double weight);
    List<Cake> findByPriceLessThan(int price);
    List<Cake> findByWeightLessThan(double weight);
    List<Cake> findByCakeCategory(CakeCategory cakeCategory);

    Cake findByCakeID(Integer cakeID);
}
