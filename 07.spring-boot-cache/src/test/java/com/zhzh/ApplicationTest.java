package com.zhzh;

import com.zhzh.mapper.Customer;
import com.zhzh.mapper.CustomerDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: jason.zhao
 * @date:2019/4/17 13:35
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class ApplicationTest {

    @Autowired
    private CustomerDao customerDao;

    @Test
    public void test(){
        Customer count = customerDao.queryById(1);
        System.out.println(count.getName());
        Customer count1 = customerDao.queryById(1);
        System.out.println(count1.getName());
    }
}
