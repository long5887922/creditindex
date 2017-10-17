package com.zy.creditindex;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ${ZhaoYing}on 2017/9/22 0022
 */
@RestController
@RequestMapping(value = "hello")
public class FistTest {

    @GetMapping(value = "say")
    public String SayHello(){
        return "Hello Spring Boot";
    }
}
