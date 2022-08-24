package com.yh.admin.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * 启动类
 *
 * @author yl_tao
 * @date 2022/4/25 11:01
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.yh.admin.service.mapper")
public class AdminServiceApplication {


    public static void main(String[] args) {
        SpringApplication.run(AdminServiceApplication.class);
    }

    @PostConstruct
    public void init(){

    }

}
