package com.spaop.aopdemo.impl;

import com.spaop.aopdemo.repository.MyInterface;
import org.springframework.stereotype.Component;

@Component
public class MyImpl implements MyInterface {

    @Override
    public String getData() {
        System.out.println("Hiiiiiiiii");
        return "Hello Spring AOP";
    }
}
