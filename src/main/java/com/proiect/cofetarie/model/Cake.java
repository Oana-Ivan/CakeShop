package com.proiect.cofetarie.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cakes")
public class Cake {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cake_id")
    private int cakeID;

    @Column(name = "cake_name")
    private String cakeName;

    @Column(name = "description")
    private String shortDescription;

    private double weight;

    private int popularityScore;

//    private List<String> possibleAllergens;

    private int price;

    @ManyToOne
//  TODO Uncomment: @JoinColumn(name = "cake_category_id")
    @JsonIgnore
    private CakeCategory cakeCategory;

    @ManyToMany
    @JoinTable(name = "cake_order", joinColumns = @JoinColumn(name = "cake_id"),
            inverseJoinColumns =  @JoinColumn(name = "order_id"))
    private List<Order> ordersList = new ArrayList<>();

    public Cake() {

    }

    public Cake(String cakeName, String shortDescription, int price, double weight) {
        this.cakeName = cakeName;
        this.shortDescription = shortDescription;
//        this.possibleAllergens = possibleAllergens;
        this.price = price;
        this.weight = weight;
//        this.category = category;
        this.popularityScore = 0;
    }

    public Cake(int cakeID, String cakeName, String shortDescription, int price, double weight) {
        this.cakeID = cakeID;
        this.cakeName = cakeName;
        this.shortDescription = shortDescription;
        this.weight = weight;
        this.price = price;
    }

    public Cake(int cakeID, String cakeName, String shortDescription, double weight, int price, CakeCategory cakeCategory) {
        this.cakeID = cakeID;
        this.cakeName = cakeName;
        this.shortDescription = shortDescription;
        this.weight = weight;
        this.price = price;
        this.cakeCategory = cakeCategory;
        this.popularityScore = 0;
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

//    public List<String> getPossibleAllergens() {
//        return possibleAllergens;
//    }
//
//    public void setPossibleAllergens(List<String> possibleAllergens) {
//        this.possibleAllergens = possibleAllergens;
//    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public CakeCategory getCakeCategory() {
        return cakeCategory;
    }

    public void setCakeCategory(CakeCategory cakeCategory) {
        this.cakeCategory = cakeCategory;
    }

    public int getPopularityScore() {
        return popularityScore;
    }

    public void setPopularityScore(int popularityScore) {
        this.popularityScore = popularityScore;
    }

    public void increasePopularityScore() {
        this.popularityScore++;
    }
}
