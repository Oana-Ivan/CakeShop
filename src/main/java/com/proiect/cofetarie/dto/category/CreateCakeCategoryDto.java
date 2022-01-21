package com.proiect.cofetarie.dto.category;

import com.proiect.cofetarie.model.Cake;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class CreateCakeCategoryDto {
    // TODO

    @NotBlank
    @Size(max = 100)
    private String categoryName;

    @NotBlank
    @Size(max = 200)
    private String categoryDescription;

    public CreateCakeCategoryDto() {
    }

    public CreateCakeCategoryDto(@NotBlank @Size(max = 100) String categoryDescription, @NotBlank @Size(max = 100) String categoryName) {
        this.categoryDescription = categoryDescription;
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
