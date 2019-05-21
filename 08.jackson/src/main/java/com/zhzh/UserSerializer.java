package com.zhzh;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * 自定义序列化
 * @Author: jason.zhao
 * @date:2019/4/25 10:43
 * @Description:
 */

public class UserSerializer extends JsonSerializer<User> {
    @Override
    public void serialize(User user, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("\\user_name",'\"'+user.getName()+'\"');
        jsonGenerator.writeEndObject();
    }
}
