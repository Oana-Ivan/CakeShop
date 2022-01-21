package com.proiect.cofetarie.dto.cake;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreateCakeWithCategoryDto extends CreateCakeDto {
    private int cakeCategoryID;

    public CreateCakeWithCategoryDto(@NotBlank @Size(max = 100) String cakeName, @NotBlank @Size(max = 100) String shortDescription, double weight, int price, int cakeCategoryID) {
        super(cakeName, shortDescription, weight, price);
        this.cakeCategoryID = cakeCategoryID;
    }

    public int getCakeCategoryID() {
        return cakeCategoryID;
    }

    public void setCakeCategoryID(int cakeCategoryID) {
        this.cakeCategoryID = cakeCategoryID;
    }
}
