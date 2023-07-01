package com.shop.model;

import android.os.Parcelable;

import java.io.Serializable;

public class Shoes implements Serializable {
    private int id;
    private String name;
    private int price;
    private int image;
    private String brand;
    private int quantity;
    private String soldNumber;
    private String describe;

    private int amount; // Thêm thuộc tính amount


    public Shoes(int id, String name, int price, int image, String brand, int quantity, String soldNumber, String describe, int amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.brand = brand;
        this.quantity = quantity;
        this.soldNumber = soldNumber;
        this.describe = describe;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSoldNumber() {
        return soldNumber;
    }

    public void setSoldNumber(String soldNumber) {
        this.soldNumber = soldNumber;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
