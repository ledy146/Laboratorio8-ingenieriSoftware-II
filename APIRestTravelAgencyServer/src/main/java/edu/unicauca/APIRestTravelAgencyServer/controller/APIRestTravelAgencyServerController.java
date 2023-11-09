/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unicauca.APIRestTravelAgencyServer.controller;

import co.unicauca.travelagency.commons.domain.Customer;
import edu.unicauca.APIRestTravelAgencyServer.services.CustomerService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ledya
 */
@RestController
@RequestMapping("/clientes")
public class APIRestTravelAgencyServerController {
    @Autowired
    private CustomerService objCustomService;
    
    @GetMapping
    public List<Customer> getCustomers(){
        return objCustomService.listCustomers();
    }
    @GetMapping("/{id}")
    public Customer findCustomer(@PathVariable String id){
        return objCustomService.findCustomer(id);
    }
    @PostMapping
    public String createCustomer(@RequestBody Customer newCustomer){
        return objCustomService.createCustomer(newCustomer);
    }
    @PutMapping
    public String updateUser(@RequestBody Customer customerMod){
        return objCustomService.updateUser(customerMod);
    }
    
    
}
