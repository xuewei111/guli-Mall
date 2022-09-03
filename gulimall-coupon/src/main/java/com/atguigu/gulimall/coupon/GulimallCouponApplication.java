package com.atguigu.gulimall.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * 1. 如何使用nacos作为配置中心统一管理
 *  1. 引入依赖
 *      <dependency>
 *             <groupId>com.alibaba.cloud</groupId>
 *             <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
 *         </dependency>
 *   2、 创建一个bootstrap.properties
 *      spring.application.name=gulimall-coupon、
 *      spring.cloud.nacos.config.server-addr=127.0.0.1:8848
 *
 *   3.需要给配置中心默认添加一个叫 数据集(Data Id) gulimall-coupon.properties 默认规则 应用名/properties
 *   4.给应用名.properties 添加任何配置
 *   5.动态获取配置
 *      @RefreshScope :动态获取并刷新配置
 *      @Value  : 获取到配置
 *      如果配置中心和当前 应用的配置文件中大都配置了相同的项,优先使用配置中心的配置
 */
@EnableDiscoveryClient
@SpringBootApplication
public class GulimallCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallCouponApplication.class, args);
    }

}
