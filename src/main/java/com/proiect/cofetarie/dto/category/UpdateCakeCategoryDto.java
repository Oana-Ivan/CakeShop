package com.proiect.cofetarie.dto.category;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateCakeCategoryDto extends CreateCakeCategoryDto {
    @NotNull
    private int cakeCategoryID;

    public UpdateCakeCategoryDto(@NotBlank @Size(max = 100) String categoryDescription, @NotBlank @Size(max = 100) String categoryName, @NotNull int cakeCategoryID) {
        super(categoryDescription, categoryName);
        this.cakeCategoryID = cakeCategoryID;
    }

    public int getCakeCategoryID() {
        return cakeCategoryID;
    }

    public void setCakeCategoryID(int cakeCategoryID) {
        this.cakeCategoryID = cakeCategoryID;
    }
}
