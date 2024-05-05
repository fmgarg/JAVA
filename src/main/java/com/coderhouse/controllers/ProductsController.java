package com.coderhouse.controllers;


import com.coderhouse.models.Products;
import com.coderhouse.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductsService productsService;

    @GetMapping(
            value = "/",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<List<Products>> getAllProducts() {
        try{
            List<Products> productsList = productsService.productsGetAll();
            return new ResponseEntity<>(productsList, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(
            value= "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<Products> getProductsById(@PathVariable("id") Integer SKU) {
        try {
            Products product = productsService.productsFindById(SKU);
            //System.out.println(product);
            if(product == null) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }else {
                return new ResponseEntity<>(product, HttpStatus.OK);
            }
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); //codigo 500
        }
    }
    @PostMapping(
            value = "/save",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Products> saveProduct(@RequestBody Products product) {
        productsService.productsSave(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }
    @PutMapping (value = "/{id}/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Products> updateProduct(
            @PathVariable("id") Integer SKU,
            @RequestBody Products product
    ) {
        Products productEdited = productsService.productsUpdate(SKU, product);
        if(productEdited == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(productEdited, HttpStatus.OK);
        }
    }
    @DeleteMapping(value = "/{id}/delete")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Integer SKU) {
        boolean deleted = productsService.productsDelete(SKU);
        System.out.println(deleted);
        if(deleted == true) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
