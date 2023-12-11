package com.example.springbootproject.service.impl;

import com.example.springbootproject.dao.CustomerRepository;
import com.example.springbootproject.dto.CustomerDto;
import com.example.springbootproject.entity.CustomerEntity;
import com.example.springbootproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;


public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerDto getCustomerDetails(Long cid){
        System.out.println("impl1");
        CustomerEntity customerEntity = customerRepository.findById(cid).orElse(null);
        if(Objects.nonNull(customerEntity)){
            CustomerDto customerDto = new CustomerDto();
            customerDto.setId(customerEntity.getId());
            customerDto.setName(customerEntity.getName());
            customerDto.setAddress(customerEntity.getAddress());
            return customerDto;
        }else{
            return  null;
        }
    }
}
