package com.nike.models;

public class Product {

    private int id;
    private String name;
    private String category;
    private int price;
    private String photo_path;

    public Product() {
    }

    public Product(int id, String name, String category, int price, String photo_path) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.photo_path = photo_path;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPhoto_path() {
        return photo_path;
    }

    public void setPhoto_path(String photo_path) {
        this.photo_path = photo_path;
    }
}
