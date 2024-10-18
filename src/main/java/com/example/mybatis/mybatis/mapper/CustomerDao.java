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
    void save(Customer customer);

    @Select("""
            select *
            from customers
            where id=#{id}""")
    Customer findById(Integer id);

    @Update("""
            update customers
            set name=#{name}, city=#{city}, email=#{email}, phone=#{phone}
            where id=#{id}""")
    void update(Customer customer);

    @Delete("""
            delete from customers
            where id=#{id}""")
    void deleteById(Integer id);

    @Select("""
            select *
            from customers""")
    List<Customer> findAll();

    @Select("""
            select *
            from customers
            where city=#{city}""")
    List<Customer> findAllCustomersByCity(String city);

}
