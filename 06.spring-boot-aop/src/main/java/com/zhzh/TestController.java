package com.zhzh;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: jason.zhao
 * @date:2019/4/15 17:13
 * @Description:
 */
@RestController
public class TestController {
    @Log("执行方法一")
    @GetMapping("/one")
    public void methodOne(String name) { }
}
