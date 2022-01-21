package com.proiect.cofetarie.dto.cake;

import com.proiect.cofetarie.dto.cake.CreateCakeDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateCakeDto extends CreateCakeDto {
    @NotNull
    private int id;

//    @NotNull
//    private int cakeCategoryId;

    public UpdateCakeDto(@NotBlank @Size(max = 100) String cakeName, @NotBlank @Size(max = 100) String shortDescription, double weight, int price, @NotNull int id) { // , @NotNull int cakeCategoryId) {
        super(cakeName, shortDescription, weight, price);
        this.id = id;
//        this.cakeCategoryId = cakeCategoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public int getCakeCategoryId() {
//        return cakeCategoryId;
//    }
//
//    public void setCakeCategoryId(int cakeCategoryId) {
//        this.cakeCategoryId = cakeCategoryId;
//    }
}
