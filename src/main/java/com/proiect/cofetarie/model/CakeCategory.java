package com.proiect.cofetarie.model;

public class CakeCategory {
    private int cakeCategoryID;
    private String categoryName;
    private String categoryDescription;

    public CakeCategory(String categoryName, String categoryDescription) {
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }

    public int getCakeCategoryID() {
        return cakeCategoryID;
    }

    public void setCakeCategoryID(int cakeCategoryID) {
        this.cakeCategoryID = cakeCategoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }
}
