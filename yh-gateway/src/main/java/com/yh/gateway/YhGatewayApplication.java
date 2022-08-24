package com.yh.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import javax.annotation.PostConstruct;

/**
 * 网关启动类
 *
 * @author yl_tao
 * @date 2022/4/27 15:01
 */
@SpringBootApplication
@EnableDiscoveryClient
public class YhGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(YhGatewayApplication.class);
    }

    @Value("${test.username}")
    private String userName;

    @PostConstruct
    public void test(){
        System.out.println("-------------"+userName);
    }
}
