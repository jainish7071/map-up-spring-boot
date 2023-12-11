package com.example.springbootproject.controller;

import com.example.springbootproject.dto.CustomerDto;
import com.example.springbootproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CusController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/getcustomerDetails/{cid}")
    public ResponseEntity<CustomerDto> getCusDetails(@PathVariable Long cid){
        CustomerDto customerDto = customerService.getCustomerDetails(cid);
        return ResponseEntity.ok(customerDto);
    }
}
