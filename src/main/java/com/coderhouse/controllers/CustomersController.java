package com.coderhouse.controllers;
import com.coderhouse.models.Customers;
import com.coderhouse.repositories.CustomersRepository;
import com.coderhouse.services.CustomersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@Tag(name = "Customers controller", description = "Customers endpoints")
public class CustomersController {

    @Autowired
    private CustomersService customersService; //CustomersRepository customersRepository;

    //public CustomersController() {}
    @Operation(summary = "List all customers")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "List of all customers",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Customers.class)
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "internal server error",
                    content = {
                            @Content()
                    }
            )
    })
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
    @Operation(summary = "List customer")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "List customer by customer id",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Customers.class)
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "internal server error",
                    content = {
                            @Content()
                    }
            )
    })
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
    @Operation(summary = "Save customer")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Save new customer",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Customers.class)
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "internal server error",
                    content = {
                            @Content()
                    }
            )
    })
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customers> saveCustomer(@RequestBody Customers customer) {
        customersService.customersSave(customer); //Repository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }
    @Operation(summary = "Update customer")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Update customer data by customer id",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Customers.class)
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "internal server error",
                    content = {
                            @Content()
                    }
            )
    })
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
    @Operation(summary = "Delete customer")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Delete customer by customer id",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Customers.class)
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "internal server error",
                    content = {
                            @Content()
                    }
            )
    })
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






