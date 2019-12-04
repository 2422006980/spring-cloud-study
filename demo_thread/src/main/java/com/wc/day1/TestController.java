package com.wc.day1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wangcheng
 * @date: 2019/12/4
 * @description
 * @version: 1.0
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello world";
    }
}
