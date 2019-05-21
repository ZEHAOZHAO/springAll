package com.zhzh;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhzh.mapper.Customer;
import com.zhzh.mapper.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @Author: jason.zhao
 * @date:2019/4/12 17:20
 * @Description:
 */
@RestController
public class TestController {
    private final CustomerDao customerDao;

    public TestController(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }


    @RequestMapping("/crm")
    public int crmCount() {

        return customerDao.count();
    }

    @Autowired
    ObjectMapper mapper;

    @RequestMapping("customize")
    @ResponseBody
    public String customize() throws JsonParseException, JsonMappingException, IOException {
        String jsonStr = "[{\"userName\":\"mrbird\",\"age\":26},{\"userName\":\"scott\",\"age\":27}]";
        JavaType type = mapper.getTypeFactory().constructParametricType(List.class, Customer.class);
        List<Customer> list = mapper.readValue(jsonStr, type);
        String msg = "";
        for (Customer user : list) {
            msg += user.getName();
        }
        return msg;
    }
}
