package com.zhzh;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: jason.zhao
 * @date:2019/4/11 14:50
 * @Description:
 */
@RestController
@SpringBootApplication
@ComponentScan("com.zhzh")
public class DemoApplication {


    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DemoApplication.class);
        //关闭banner
        app.setBannerMode(Banner.Mode.OFF);
        //项目配置不被命令行修改
        app.setAddCommandLineProperties(false);
        app.run(args);
    }
}