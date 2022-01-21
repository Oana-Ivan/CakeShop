package com.proiect.cofetarie.dto.cake;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreateCakeDto {
    @NotBlank
    @Size(max = 100)
    private String cakeName;

    @NotBlank
    @Size(max = 100)
    private String shortDescription;

    private double weight;

    private int price;

    public CreateCakeDto() {
    }

    public CreateCakeDto(@NotBlank @Size(max = 100) String cakeName, @NotBlank @Size(max = 100) String shortDescription, double weight, int price) {
        this.cakeName = cakeName;
        this.shortDescription = shortDescription;
        this.weight = weight;
        this.price = price;
    }

    public String getCakeName() {
        return cakeName;
    }

    public void setCakeName(String cakeName) {
        this.cakeName = cakeName;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
