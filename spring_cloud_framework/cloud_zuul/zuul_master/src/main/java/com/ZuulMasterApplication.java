package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author: wangcheng
 * @date: 2019/11/19
 * @description
 * @version: 1.0
 */
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class ZuulMasterApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulMasterApplication.class, args);
    }
}
