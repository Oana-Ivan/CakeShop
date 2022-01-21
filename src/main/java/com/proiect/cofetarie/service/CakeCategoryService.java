package com.proiect.cofetarie.service;

import com.proiect.cofetarie.exception.category.CakeCategoryNotFoundException;
import com.proiect.cofetarie.model.CakeCategory;
import com.proiect.cofetarie.repository.CakeCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CakeCategoryService {
    private CakeCategoryRepository cakeCategoryRepository;

    public CakeCategoryService(CakeCategoryRepository cakeCategoryRepository) {
        this.cakeCategoryRepository = cakeCategoryRepository;
    }

    public CakeCategory create(CakeCategory cakeCategory) {
        // TODO validate cake category: name unique
        return cakeCategoryRepository.save(cakeCategory);
    }

    public List<CakeCategory> get(String name) {
        return cakeCategoryRepository.findByCategoryName(name);
    }

    public CakeCategory update(CakeCategory update) {
        CakeCategory existingCakeCategory = cakeCategoryRepository.findById(update.getCakeCategoryID())
                .orElseThrow(() -> new CakeCategoryNotFoundException(update.getCakeCategoryID()));
        return cakeCategoryRepository.save(update);
    }

    public boolean delete(int id) {
        CakeCategory cakeCategory = cakeCategoryRepository.findById(id).orElse(null);
        if (cakeCategory == null) {
            throw new CakeCategoryNotFoundException(id);
        }
        cakeCategoryRepository.deleteById(id);
        return true;
    }
}
