package com.zhzh;

import com.zhzh.bidao.OrderDao;
import com.zhzh.crmdao.CustomerDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: jason.zhao
 * @date:2019/4/12 17:20
 * @Description:
 */
@RestController
public class TestController {
    private final OrderDao orderDao;
    private final CustomerDao customerDao;

    public TestController(OrderDao orderDao, CustomerDao customerDao) {
        this.orderDao = orderDao;
        this.customerDao = customerDao;
    }

    @RequestMapping("/bi")
    public int biCount(){
        return orderDao.count();
    }
    @RequestMapping("/crm")
    public int crmCount(){
        return customerDao.count();
    }
}
