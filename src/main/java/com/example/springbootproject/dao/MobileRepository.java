package com.example.springbootproject.dao;

import com.example.springbootproject.entity.MobileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MobileRepository extends JpaRepository<MobileEntity,Integer> {
}
