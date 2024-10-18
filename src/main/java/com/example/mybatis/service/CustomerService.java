package com.example.mybatis.service;

import com.example.mybatis.entity.Customer;
import com.example.mybatis.mybatis.mapper.CustomerDao;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Service
public class CustomerService {

    CustomerDao customerDao;

    public Customer create(Customer customer) {
        customerDao.save(customer);
        return customer;
    }

    public Customer findById(Integer id) {
        return customerDao.findById(id);
    }

    public Customer update(Customer customer) {
        Customer founded = findById(customer.getId());
        if (founded == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Customer not found by id=%s".formatted(customer.getId()));
        }
        customerDao.update(customer);
        return customerDao.findById(customer.getId());
    }

    public void deleteById(Integer id) {
        Customer founded = findById(id);
        if (founded == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Customer not found by id=%s".formatted(id));
        }
        customerDao.deleteById(id);
    }

}
