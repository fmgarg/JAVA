package com.coderhouse.services;

import com.coderhouse.models.Orders;
import com.coderhouse.models.Products;
import com.coderhouse.repositories.OrdersRepository;
import com.coderhouse.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private ProductsRepository productsRepository;
    public List<Orders> ordersGetAll() {
        return ordersRepository.findAll();
    }
    public Orders ordersGetById(int id) {
        return ordersRepository.findById(id).orElse(null);
    }
    public Orders ordersSave(Orders order) {
        return ordersRepository.save(order);
    }
    public void updateProductStock(Products product, int quantity) {
        product.setStock(product.getStock() - quantity);
        productsRepository.save(product);
    }
}
