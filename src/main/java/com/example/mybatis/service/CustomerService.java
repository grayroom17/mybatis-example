package com.example.mybatis.service;

import com.example.mybatis.entity.Customer;
import com.example.mybatis.mybatis.mapper.CustomerDao;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Service
public class CustomerService {

    CustomerDao customerDao;

    public Customer create(Customer customer) {
        customerDao.save(customer);
        return customer;
    }

}
