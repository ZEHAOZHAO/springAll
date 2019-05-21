package com.zhzh;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: jason.zhao
 * @date:2019/4/25 15:47
 * @Description:
 */
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.zhzh")
public class SpringTestConfig {
}
