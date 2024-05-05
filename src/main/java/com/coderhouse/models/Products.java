package com.coderhouse.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Products")
public class Products {
    @Id
    @Column(name = "SKU")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer SKU;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "stock")
    private Integer stock;
    @Column(name = "price")
    private Integer price;


    public Products() {

    }

    public Integer getSKU() {
        return SKU;
    }

    public void setSKU(Integer SKU) {
        this.SKU = SKU;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
