package com.coderhouse.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.List;
@Schema(description = "Products Model")
@Entity
@Table(name = "Products")
public class Products {
    @Schema(description = "Product Id/ sku", requiredMode = Schema.RequiredMode.NOT_REQUIRED, example = "AutoGeneratedValue")
    @Id
    @Column(name = "SKU")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer SKU;
    @Schema(description = "Product title", requiredMode = Schema.RequiredMode.REQUIRED, example = "Laptop")
    @Column(name = "title")
    private String title;
    @Schema(description = "Product description", requiredMode = Schema.RequiredMode.REQUIRED, example = "AMD Ryzen 5 5500u 16GB 256SSD")
    @Column(name = "description")
    private String description;
    @Schema(description = "Product stock", requiredMode = Schema.RequiredMode.REQUIRED, example = "35")
    @Column(name = "stock")
    private Integer stock;
    @Schema(description = "Product price", requiredMode = Schema.RequiredMode.REQUIRED, example = "1200")
    @Column(name = "price")
    private Integer price;
    @Schema(description = "Products list array")
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<OrderProduct> orderProducts;


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

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }
}
