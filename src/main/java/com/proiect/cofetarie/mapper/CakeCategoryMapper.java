package com.proiect.cofetarie.mapper;

import com.proiect.cofetarie.dto.address.UpdateDeliveryAddressDTO;
import com.proiect.cofetarie.dto.category.CreateCakeCategoryDto;
import com.proiect.cofetarie.dto.category.UpdateCakeCategoryDto;
import com.proiect.cofetarie.model.CakeCategory;
import org.springframework.stereotype.Component;

@Component
public class CakeCategoryMapper {
    public CakeCategory create(CreateCakeCategoryDto category) {
        return new CakeCategory(category.getCategoryName(), category.getCategoryDescription());
    }

    public CakeCategory update(UpdateCakeCategoryDto category) {
        return new CakeCategory(category.getCakeCategoryID(), category.getCategoryName(), category.getCategoryDescription());
    }
}
