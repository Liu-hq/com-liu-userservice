package com.liu.userservice.service;

import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/7/19.
 */
@Service
public class TestService {

    public String test(){
        int a = 1/0;
        return "aaaaaa";
    }

}
