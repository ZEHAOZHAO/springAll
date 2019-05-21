package com.zhzh;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

/**
 * @Author: jason.zhao
 * @date:2019/4/25 10:48
 * @Description:
 */
public class UserDeserializer extends JsonDeserializer<User> {
    @Override
    public User deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode treeNode = jsonParser.getCodec().readTree(jsonParser);
        String user_name = treeNode.get("user_name").asText();
        User user = new User();
        user.setName(user_name);
        return user;
    }
}
