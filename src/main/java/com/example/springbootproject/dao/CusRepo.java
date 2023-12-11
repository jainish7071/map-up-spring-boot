package com.example.springbootproject.dao;

import com.example.springbootproject.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CusRepo extends JpaRepository<CustomerEntity, Long> {
}
