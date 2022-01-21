package com.proiect.cofetarie.service;

import com.proiect.cofetarie.model.CakeCategory;
import com.proiect.cofetarie.model.DeliveryAddress;
import com.proiect.cofetarie.repository.CakeCategoryRepository;
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

@ExtendWith(MockitoExtension.class)
class CakeCategoryServiceTest {
    @Mock
    private CakeCategoryRepository cakeCategoryRepository;
    @InjectMocks
    private CakeCategoryService categoryService;

    @Test
    @DisplayName("created successfully")
    void create() {
        // arrange
        CakeCategory cakeCategory = new CakeCategory("fruit cakes", "-");
        Mockito.when(cakeCategoryRepository.save(cakeCategory)).thenReturn(cakeCategory);

        // act
        CakeCategory result = categoryService.create(cakeCategory);

        // assert
        assertNotNull(result);
        Mockito.verify(cakeCategoryRepository).save(cakeCategory);
    }

    @Test
    @DisplayName("get success")
    void get() {
        // arrange
        CakeCategory cakeCategory = new CakeCategory("fruit cakes", "-");
        Mockito.when(cakeCategoryRepository.findByCategoryName(cakeCategory.getCategoryName())).thenReturn(List.of(cakeCategory));

        // act
        List<CakeCategory> result = categoryService.get(cakeCategory.getCategoryName());

        // assert
        assertNotNull(result);
        Mockito.verify(cakeCategoryRepository).findByCategoryName(cakeCategory.getCategoryName());
    }

    @Test
    void update() {
        // arrange
        CakeCategory cakeCategory = new CakeCategory(1, "fruit cakes", "-");
        Mockito.when(cakeCategoryRepository.findById(cakeCategory.getCakeCategoryID())).thenReturn(java.util.Optional.of(cakeCategory));

        // act
        CakeCategory result = categoryService.update(cakeCategory);

        // assert
        Mockito.verify(cakeCategoryRepository).findById(cakeCategory.getCakeCategoryID());

    }

    @Test
    void delete() {
        // arrange
        int id = 1;
        CakeCategory cakeCategory = new CakeCategory(1, "fruit cakes", "-");
        Mockito.when(cakeCategoryRepository.findById(id)).thenReturn(Optional.of(cakeCategory));

        // act
        boolean result = categoryService.delete(id);

        // assert
        assertTrue(result);
        Mockito.verify(cakeCategoryRepository).deleteById(id);
    }
}