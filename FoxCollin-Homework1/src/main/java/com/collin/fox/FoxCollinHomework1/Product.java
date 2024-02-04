package com.collin.fox.FoxCollinHomework1;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
public class Product {
    @Id
    private int SKU;
    private String NAME;
    private String DESCRIPTION;
    @Column(name="CATEGORY")
    private String CATEGORY;
    private double PRICE;

    public Product(){}


    public Product(int SKU, String NAME, String DESCRIPTION, String CATEGORY, double PRICE) {
        this.SKU = SKU;
        this.NAME = NAME;
        this.DESCRIPTION = DESCRIPTION;
        this.CATEGORY = CATEGORY;
        this.PRICE = PRICE;
    }

    public int getSKU() {
        return SKU;
    }

    public void setSKU(int SKU) {
        this.SKU = SKU;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public String getCATEGORY() {
        return CATEGORY;
    }

    public void setCATEGORY(String CATEGORY) {
        this.CATEGORY = CATEGORY;
    }

    public double getPRICE() {
        return PRICE;
    }

    public void setPRICE(double PRICE) {
        this.PRICE = PRICE;
    }

    @Override
    public String toString(){
        return this.NAME + " " + this.PRICE + this.DESCRIPTION;
    }

}
