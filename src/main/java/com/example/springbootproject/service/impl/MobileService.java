package com.example.springbootproject.service.impl;

import com.example.springbootproject.dao.MobileRepository;
import com.example.springbootproject.entity.MobileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MobileService {
    @Autowired
    private MobileRepository mobileRepository;

    public MobileEntity createMobile(MobileEntity mobile){
        return mobileRepository.save(mobile);
    }

    public List<MobileEntity> getMobiles(){
        return  mobileRepository.findAll();
    }

    public MobileEntity getMobileById(int id){
        return mobileRepository.findById(id).orElse(null);
    }

    public MobileEntity updateMobile(MobileEntity mobile,int id){
        Optional<MobileEntity> optionalMobile =  mobileRepository.findById(id);
        if(optionalMobile.isPresent()){
            MobileEntity oldMobile = optionalMobile.get();
            oldMobile.setMobileImage(mobile.getMobileImage());
            oldMobile.setDiscount(mobile.getDiscount());
            oldMobile.setName(mobile.getName());
            oldMobile.setPrice(mobile.getPrice());
            oldMobile.setEffectivePrice(mobile.getEffectivePrice());
            oldMobile.setDeliveryType(mobile.getDeliveryType());
            oldMobile.setDetailsList(mobile.getDetailsList());
            return mobileRepository.save(oldMobile);
        }else{
            return null;
        }
    }

    public boolean deleteMobile(int id){
        try{
        mobileRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
