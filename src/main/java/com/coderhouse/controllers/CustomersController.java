package com.coderhouse.controllers;
import com.coderhouse.models.Customers;
import com.coderhouse.repositories.CustomersRepository;
import com.coderhouse.services.CustomersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomersController {

    @Autowired
    private CustomersService customersService; //CustomersRepository customersRepository;

    //public CustomersController() {}

    @GetMapping(
            value= "/",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<List<Customers>> getAllCustomers() {
        try {
            List<Customers> customersList = customersService.customersFindAll();
            return new ResponseEntity<>(customersList, HttpStatus.OK); //código 200
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); //código 500
        }

    }
    @GetMapping(value= "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Customers> getCustomerById(@PathVariable ("id") Integer dni) {
        try {
            Customers customer = customersService.customersFindById(dni); //.findById(dni).orElse(null);
            //System.out.println(customer);
            if(customer == null) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }else {
                return new ResponseEntity<>(customer, HttpStatus.OK); //código 200
            }
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); //código 500
        }
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customers> saveCustomer(@RequestBody Customers customer) {
        customersService.customersSave(customer); //Repository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @PutMapping (value = "/{id}/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customers> updateCustomer(
            @PathVariable ("id") Integer dni,
            @RequestBody Customers customer
    ) {
       Customers  customerEdited = customersService.customersUpdate(dni, customer);
       if(customerEdited == null) {
           return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
       }else {
           return new ResponseEntity<>(customerEdited, HttpStatus.OK);
       }
    }

    @DeleteMapping (value = "/{id}/delete")
    public ResponseEntity<Void> deleteCustomer(@PathVariable ("id") Integer dni) {
        boolean deleted = customersService.customersDelete(dni);
        System.out.println(deleted);
        if(deleted == true) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); //ok 204
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);//error 404
        }
    }
}






