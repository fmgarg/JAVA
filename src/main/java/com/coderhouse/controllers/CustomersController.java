package com.coderhouse.controllers;
import com.coderhouse.models.Customers;
import com.coderhouse.repositories.CustomersRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomersController {

    @Autowired
    private CustomersRepository customersRepository;

    //public CustomersController() {}

    @GetMapping(
            value= "/",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<List<Customers>> getAllCustomers() {
        try {
            List<Customers> customersList = customersRepository.findAll();
            return new ResponseEntity<>(customersList, HttpStatus.OK); //código 200
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); //código 500
        }

    }
    @GetMapping(value= "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Customers> getCustomerById(@PathVariable ("id") Integer dni) {
        try {
            Customers customer = customersRepository.findById(dni).orElse(null);
            if(customer == null) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }else {
                return new ResponseEntity<>(customer, HttpStatus.OK); //código 200
            }
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); //código 500
        }
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customers> addCustomer(@RequestBody Customers customer) {
        customersRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }


}






