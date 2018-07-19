package com.liu.userservice.controller;

import com.liu.userservice.service.TestService;
import com.liu.userservice.utils.MyHealthChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/7/12.
 */
@RestController
public class TestController {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    private MyHealthChecker myHealthChecker;

    @Autowired
    private TestService testService;

    @RequestMapping(value="/userservice/api")
    public String goUploadImg() {
        System.out.println("111111111111122222");
//        try {
//            Thread.sleep(30000L);
//            throw new Exception("抛出异常");

//        }catch (Exception e){
//            e.printStackTrace();
//        }
        testService.test();
        return "1111111111111";
    }

    @PostMapping(value="/send")
    public String send(String name) {

        kafkaTemplate.send("TextLinesTopic",name);
        return "succeed";
    }

    @PostMapping(value="/up")
    public String up(@RequestParam("up") Boolean up) {
        myHealthChecker.setUp(up);
        return up.toString();
    }


}
