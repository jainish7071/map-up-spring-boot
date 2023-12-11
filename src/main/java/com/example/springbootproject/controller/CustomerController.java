package com.example.springbootproject.controller;

import com.example.springbootproject.dto.CustomerDto;
import com.example.springbootproject.dto.CustomerRequestDto;
import com.example.springbootproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/getCustomerDetails/{cid}")
    public ResponseEntity<CustomerDto> getCustomerDetails(@PathVariable Long cid) {
        CustomerDto customerDto = customerService.getCustomerDetails(cid);
        return ResponseEntity.ok(customerDto);
    }

}
