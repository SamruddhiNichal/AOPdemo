package com.spaop.aopdemo.contoller;

import com.spaop.aopdemo.impl.MyImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Mycontroller {

    @Autowired
    private MyImpl myImpl;


    @GetMapping("/check")
    public String check(){
        return myImpl.getData();
    }
}
