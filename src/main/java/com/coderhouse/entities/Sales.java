package com.coderhouse.entities;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name="Sales")
public class Sales implements com.coderhouse.repositories.SalesRepository {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "customer_id") // Nombre de la columna de clave externa en la tabla de ventas
    private Customers customer;
    @ManyToOne
    @JoinColumn(name = "product_id") // Nombre de la columna de clave externa en la tabla de ventas
    private Products product;
    private Date saleDate;
    private double totalAmount;

    // Constructor sin argumentos
    public Sales() {
    }

    // Getters y setters

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Customers getCustomer() {
        return customer;
    }

    @Override
    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    @Override
    public Products getProduct() {
        return product;
    }

    @Override
    public void setProduct(Products product) {
        this.product = product;
    }

    @Override
    public Date getSaleDate() {
        return saleDate;
    }

    @Override
    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    @Override
    public double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
