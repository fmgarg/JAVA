package com.coderhouse.repositories;

import com.coderhouse.entities.Customers;
import com.coderhouse.entities.Products;

import java.util.Date;

public interface SalesRepository {
    Long getId();

    void setId(Long id);

    Customers getCustomer();

    void setCustomer(Customers customer);

    Products getProduct();

    void setProduct(Products product);

    Date getSaleDate();

    void setSaleDate(Date saleDate);

    double getTotalAmount();

    void setTotalAmount(double totalAmount);
}
