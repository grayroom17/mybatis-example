package com.example.mybatis.controller;

import com.example.mybatis.entity.Customer;
import com.example.mybatis.service.CustomerService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {

    CustomerService service;

    @PostMapping
    public Customer findAll(@RequestBody Customer customer) {
        return service.create(customer);
    }

}
