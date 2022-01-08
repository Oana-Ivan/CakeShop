package com.proiect.cofetarie.model;

import java.util.List;

public class Cake {
    private int cakeID;
    private String cakeName;
    private String shortDescription;
    private List<String> possibleAllergens;
    private int price;
    private CakeCategory category;

    public Cake(String cakeName, String shortDescription, List<String> possibleAllergens, int price, CakeCategory category) {
        this.cakeName = cakeName;
        this.shortDescription = shortDescription;
        this.possibleAllergens = possibleAllergens;
        this.price = price;
        this.category = category;
    }

    public int getCakeID() {
        return cakeID;
    }

    public void setCakeID(int cakeID) {
        this.cakeID = cakeID;
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

    public List<String> getPossibleAllergens() {
        return possibleAllergens;
    }

    public void setPossibleAllergens(List<String> possibleAllergens) {
        this.possibleAllergens = possibleAllergens;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public CakeCategory getCategory() {
        return category;
    }

    public void setCategory(CakeCategory category) {
        this.category = category;
    }
}
