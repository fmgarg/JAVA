package com.coderhouse.repositories;

import com.coderhouse.models.Customers;
import com.coderhouse.models.Products;

import java.util.Date;

public interface OrdersRepository {
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
