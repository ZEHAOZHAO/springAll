package com.zhzh.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhzh.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @Author: jason.zhao
 * @date:2019/4/24 18:45
 * @Description:
 */
@RestController
public class JasonController {
    @Autowired
    ObjectMapper mapper;


    @RequestMapping("customize")
    @ResponseBody
    public String customize() throws JsonParseException, JsonMappingException, IOException {
        String jsonStr = "[{\"name\":\"mrbird\",\"age\":26},{\"name\":\"scott\",\"age\":27}]";
        JavaType type = mapper.getTypeFactory().constructParametricType(List.class, User.class);
        List<User> list = mapper.readValue(jsonStr, type);
        String msg = "";
        for (User user : list) {
            msg += user.getName();
        }
        return msg;
    }
    @RequestMapping("/serialization")
    @ResponseBody
    public String serialization() throws JsonProcessingException {
        User user = new User();
        user.setName("2222");
        user.setPassword("3333");
        user.setId(2);
        String s = mapper.writeValueAsString(user);
        return s;
    }
    @JsonView(User.AllUserFieldView.class)
    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser() throws JsonProcessingException {
        User user = new User();
        user.setName("2222");
        user.setPassword("3333");
        user.setId(2);

        return user;
    }
    @RequestMapping("readJson")
    @ResponseBody
    public String readJsonString(){
        String json = "{\"name\":\"mrbird\",\"hobby\":{\"first\":\"sleep\",\"second\":\"eat\"}}";
        try {
            JsonNode jsonNode = mapper.readTree(json);
            JsonNode hobby = jsonNode.get("hobby");
            JsonNode first = hobby.get("first");
            return first.asText();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("readjsonasobject")
    @ResponseBody
    public String readJsonAsObject() {
        try {
            String json = "{\"user_name\":\"mrbird\",\"password\":26}";
            User user = mapper.readValue(json, User.class);
            String name = user.getName();
            String age = user.getPassword();
            return name + " " + age;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
