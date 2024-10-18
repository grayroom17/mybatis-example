package com.example.mybatis.controller;

import com.example.mybatis.entity.Customer;
import com.example.mybatis.service.CustomerService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {

    CustomerService service;

    @PostMapping
    public Customer create(@RequestBody Customer customer) {
        return service.create(customer);
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PutMapping
    public Customer update(@RequestBody Customer customer) {
        return service.update(customer);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        service.deleteById(id);
    }

    @GetMapping("/list")
    public List<Customer> findByCity(@RequestParam String city){
        return service.findByCity(city);
    }

    @GetMapping
    public List<Customer> findAll(){
        return service.findAll();
    }

}
