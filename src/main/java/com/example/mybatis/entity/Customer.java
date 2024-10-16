package com.example.mybatis.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    Integer id;
    String name;
    String city;
    String email;
    String phone;

}
