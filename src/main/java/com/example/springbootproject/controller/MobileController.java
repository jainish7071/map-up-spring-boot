package com.example.springbootproject.controller;

import com.example.springbootproject.entity.MobileEntity;
import com.example.springbootproject.service.impl.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mobile")
public class MobileController {

    @Autowired
    private MobileService mobileService;

    @GetMapping("")
    @ResponseBody
    public List<MobileEntity> getMobileList(){
        return mobileService.getMobiles();
    }

//    "/1" - path variable
//    "?id=1&name=fjadkfj" - query params

    @GetMapping("/{id}")
    @ResponseBody
    public MobileEntity getMobileById(@PathVariable int id){
        return mobileService.getMobileById(id);
    }

    @PostMapping("")
    @ResponseBody
    public MobileEntity addMobile(@RequestBody MobileEntity mobile){
        return mobileService.createMobile(mobile);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public boolean deleteMobile(@PathVariable int id){
        return mobileService.deleteMobile(id);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public MobileEntity updateMobile(@RequestBody MobileEntity mobile,@PathVariable int id){
        return mobileService.updateMobile(mobile,id);
    }
}
