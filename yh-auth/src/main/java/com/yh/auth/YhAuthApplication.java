package com.yh.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * TODO
 *
 * @author yl_tao
 * @date 2022/4/28 14:15
 */
@SpringBootApplication
@EnableFeignClients("com.yh.admin.service.feign")
@EnableDiscoveryClient
public class YhAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(YhAuthApplication.class);
    }
}
