package com.zhzh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: jason.zhao
 * @date:2019/4/11 16:23
 * @Description:
 */
@RestController
public class IndexController {
    @Autowired
    private BlogProperties blogProperties;
    @Autowired
    private TestConfigBean testConfigBean;

    @RequestMapping("/")
    String index() {
        return blogProperties.getName()+"——"+blogProperties.getTitle()+blogProperties.getWholeTitle();
    }
    @RequestMapping("/01")
    String index01() {
        return testConfigBean.getName()+"——"+testConfigBean.getAge();
    }
}
