package com.example.springbootproject.service.impl;

import com.example.springbootproject.dto.CustomerDto;
import com.example.springbootproject.service.CustomerService;

public class CustomerServiceImpl2 implements CustomerService {

    @Override
    public CustomerDto getCustomerDetails(Long cid) {
        System.out.println("Impl2");
        return new CustomerDto();
    }
}
