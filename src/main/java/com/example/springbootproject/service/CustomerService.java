package com.example.springbootproject.service;

import com.example.springbootproject.dto.CustomerDto;

public interface CustomerService {
    public CustomerDto getCustomerDetails(Long cid);
}
