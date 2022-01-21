package com.proiect.cofetarie.repository;

import com.proiect.cofetarie.model.CakeCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CakeCategoryRepository extends JpaRepository<CakeCategory, Integer> {
    List<CakeCategory> findByCategoryName(String name);

    CakeCategory findFirstByCategoryName(String name);
}
