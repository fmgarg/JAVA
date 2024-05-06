package com.coderhouse.services;

import com.coderhouse.models.Customers;
import com.coderhouse.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomersService {

    @Autowired
    private CustomersRepository customersRepository;
    public List<Customers> customersFindAll() {
        return customersRepository.findAll();
    }
    public Customers customersFindById(int dni) {
        return customersRepository.findById(dni).orElse(null); //.get();//.orElse(null);
    }
    public Customers customersSave(Customers customer) {
        return customersRepository.save(customer);
    }
    public Customers customersUpdate(Integer dni, Customers customer) {
        if (customersRepository.existsById(dni)){ //.findById(customer.getDni()) != null) { //.existsById(dni)) //return true or false
            customer.setDni(dni);
            return customersRepository.save(customer);
        }
        return null;
    }
    public boolean customersDelete(int dni) {
        if (customersRepository.existsById(dni)) { //customersRepository.findById(dni) != null
            customersRepository.deleteById(dni);
            return true;
        }
        return false;
    }


  /*  public Customers customersDelete(Integer dni) {
        if (customersRepository.findById(dni) != null) {
            customersRepository.deleteById(dni);
            return customersRepository.findById(dni).get();
        }
        return null;
    }*/

    /*public boolean customersDelete(Integer dni) {
        try{
            customersRepository.deleteById(dni);
            return true;
        }catch(EmptyResultDataAccessException e){
        return false;
        }
    }*/


}
