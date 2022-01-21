package com.proiect.cofetarie.service;

import com.proiect.cofetarie.exception.cake.CakeAlreadyExistsException;
import com.proiect.cofetarie.exception.cake.CakeNotFoundByIDException;
import com.proiect.cofetarie.exception.category.CakeCategoryNotFoundByNameException;
import com.proiect.cofetarie.exception.category.CakeCategoryNotFoundException;
import com.proiect.cofetarie.exception.general.PriceEqualToZeroException;
import com.proiect.cofetarie.model.Cake;
import com.proiect.cofetarie.model.CakeCategory;
import com.proiect.cofetarie.repository.CakeCategoryRepository;
import com.proiect.cofetarie.repository.CakeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CakeService {
    private CakeRepository cakeRepository;
    private CakeCategoryRepository categoryRepository;

    public CakeService(CakeRepository cakeRepository, CakeCategoryRepository categoryRepository) {
        this.cakeRepository = cakeRepository;
        this.categoryRepository = categoryRepository;
    }

    public Cake create(Cake cake, int cakeCategoryID) {
        if (cake.getPrice() == 0) {
            throw new PriceEqualToZeroException();
        }

        CakeCategory cakeCategory = categoryRepository.findById(cakeCategoryID).orElse(null);
        if (cakeCategory == null) {
            throw new CakeCategoryNotFoundException(cakeCategoryID);
        }
        cake.setCakeCategory(cakeCategory);

//        checkUniqueName(cake);
        return cakeRepository.save(cake);
    }

    public Cake update(Cake updateCake) {
        return cakeRepository.save(updateCake);
    }

//    public List<Cake> getByName(String name) {
//        if (name != null) {
//            return cakeRepository.findByCakeName(name).orElseThrow(() -> new CakeNotFoundException(name));
//        }
//        return cakeRepository.findAll();
//    }

    public List<Cake> get(Double weight, Integer price) {
        if (weight == null && price != null) {
            return cakeRepository.findByPriceLessThan(price);
        }
        if (weight != null && price == null) {
            return cakeRepository.findByWeightLessThan(weight);
        }
        if (weight != null && price != null) {
            return cakeRepository.findByPriceLessThanAndWeightLessThan(price, weight);
        }
        return cakeRepository.findAll();
    }

    public List<Cake> get(String categoryName) {
        if (categoryName != null) {
            CakeCategory cakeCategory = categoryRepository.findFirstByCategoryName(categoryName);
            if (cakeCategory != null) {
                return cakeRepository.findByCakeCategory(cakeCategory);
            }
        }
        throw new CakeCategoryNotFoundByNameException(categoryName);
    }

    private void checkUniqueName(Cake cake) {
        Optional<Cake> existingCake = cakeRepository.findByCakeName(cake.getCakeName());

        if (existingCake.isPresent()) {
            throw new CakeAlreadyExistsException();
        }
    }

    public boolean delete(int id) {
        Cake cake = cakeRepository.findById(id).orElse(null);
        if (cake == null) {
            throw new CakeNotFoundByIDException(id);
        }
        cakeRepository.deleteById(id);
        return true;
    }

    public void increasePopularityScoreById(int cakeId) {
        Cake cake = cakeRepository.findByCakeID(cakeId);
        if (cake != null) {
            cake.increasePopularityScore();
            update(cake);
        }
    }
}
