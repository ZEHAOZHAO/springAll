package com.zhzh;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: jason.zhao
 * @date:2019/4/12 15:48
 * @Description:
 */
@RestController
public class CustomerController {

    private final CustomerDaoImpl customerDao;

    public CustomerController(CustomerDaoImpl customerDao) {
        this.customerDao = customerDao;
    }
    @RequestMapping("/add")
    public int add(){
        Customer customer = new Customer();
        customer.setName("火星");
        customer.setLat(13.01);
        customer.setLon(15.01);
        return customerDao.add(customer);
    }

    @RequestMapping("/update")
    public int update(){
        Customer customer = new Customer();
        customer.setName("火星");
        customer.setLon(12.01);
        customer.setId(7);
        return customerDao.update(customer);
    }
}
