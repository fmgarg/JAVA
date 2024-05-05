package com.coderhouse.services;

import com.coderhouse.models.Products;
import com.coderhouse.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    @Autowired
    private ProductsRepository productsRepository;
    public List<Products> productsGetAll() {
        return productsRepository.findAll();
    }
    public Products productsFindById(int SKU) {
        return productsRepository.findById((long) SKU).orElse(null);
    }
    public Products productsSave(Products product) {
        return productsRepository.save(product);
    }
    public Products productsUpdate(int SKU, Products product) {
       if(productsRepository.existsById((long) SKU)) {
           product.setSKU(SKU);
           return productsRepository.save(product);
       }
       return null;
    }
    public boolean productsDelete(int SKU) {
        if(productsRepository.existsById((long) SKU)) {
            productsRepository.deleteById((long) SKU);
            return true;
        }
        return false;
    }
}
