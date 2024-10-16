package com.example.mybatis.mybatis.mapper;

import com.example.mybatis.entity.Customer;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CustomerDao {

    @Insert("""
            insert into customers (name, city, email, phone)
            values (#{name},#{city},#{email}, #{phone})""")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void addCustomer(Customer customer);

    @Select("""
            select *
            from customers
            where id=#{id}""")
    Customer getCustomerById(Integer id);

    @Update("""
            update customers
            set name=#{name}, city=#{city}, email=#{emeil}, phone=#{phone}
            where id=#{id}""")
    void updateCustomer(Customer customer);

    @Delete("""
            delete from customers
            where id=#{id}""")
    void deleteCustomerById(Integer id);

    @Select("""
            select *
            from customers""")
    List<Customer> findAllCustomers();

    @Select("""
            select *
            from customers
            where city=#{city}""")
    List<Customer> findAllCustomersByCity(String city);

}
