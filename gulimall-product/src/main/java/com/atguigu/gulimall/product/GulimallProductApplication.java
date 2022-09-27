package com.atguigu.gulimall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 1.整合Mybatis-Plus
 *      1.导入依赖
 *      <dependency>
 *             <groupId>com.baomidou</groupId>
 *             <artifactId>mybatis-plus-boot-starter</artifactId>
 *             <version>3.2.0</version>
 *         </dependency>
 *       2.配置
 *           1、配置数据源
 *              1.导入数据库的驱动
 *              2.在application.yml配置数据源相关信息
 *           2、配置Mybatis-Plus
 *              1.使用@MapperScan
 *              2.告诉Mybatis-Plus，sql映射文件位置
 * 2.逻辑删除
 *      1.配置全局的逻辑删除规则(省略)
 *      2.配置逻辑删除的组件Bean (省略)
 *      3.给bean加上逻辑删除注解@TableLogic
 *
 * 3.JSR303
 *      1.给Bean添加效验注解:javax.validation.constraints,并定义自己的message提示
 *      2.开启效验功能@Valid
 *          效果:效验错误以后会有默认的响应
 *      3.给效验的bean后紧跟一个BindingResult,就可以获取到效验的结果
 *      4.分组效验 (多场景的复杂效验)
 *          1.@NotBlank(message = "品牌名必须提交",groups = {AddGroup.class,UpdateGroup.class})
 *          给效验注解标注什么情况需要进行效验
 *          2.@Validated(value = AddGroup.class)
 *          3.默认没有指定分组的效验注解@NotBlank,在分组效验情况@Validated({AddGroup.class})下不生效
 *      5.自定义效验
 * 4.统一的异常处理类
 * @ControllerAdvice
 *      1.编写异常处理类,使用@ControllerAdvice
 *      2.使用@ExceptionHandler标注方法可以处理的异常
 *
 */
@SpringBootApplication
@MapperScan("com.atguigu.gulimall.product.dao")
@EnableDiscoveryClient
public class GulimallProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(GulimallProductApplication.class);
    }
}
