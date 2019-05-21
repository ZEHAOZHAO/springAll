package com.zhzh.jackson;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.zhzh.User;
import com.zhzh.UserData;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static com.fasterxml.jackson.core.JsonEncoding.UTF8;

/**
 * @Author: jason.zhao
 * @date:2019/4/24 14:49
 * @Description:
 */
public class JacksonTest {
    public static void main(String[] args) {

       /* User user = new User();
        user.setId(1);
        user.setName("小明");
        user.setPassword("123456");
        writerJson(user);*/
      /*  User user = readJson();
        System.out.println(user.getId());*/
       /* convertJson();*/
        jsonGenrator();
    }
    public static void jsonParse() throws IOException {
        JsonFactory jasonFactory = new JsonFactory();
        JsonParser jsonParser = jasonFactory.createJsonParser(new File("D:\\project\\springAll\\08.jackson\\lib\\jsonGenerator.json"));
        while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
            //get the current token
            String fieldname = jsonParser.getCurrentName();
            if ("name".equals(fieldname)) {
                //move to next token
                jsonParser.nextToken();
                System.out.println(jsonParser.getText());
            }
            if("age".equals(fieldname)){
                //move to next token
                jsonParser.nextToken();
                System.out.println(jsonParser.getNumberValue());
            }
            if("verified".equals(fieldname)){
                //move to next token
                jsonParser.nextToken();
                System.out.println(jsonParser.getBooleanValue());
            }
            if("marks".equals(fieldname)){
                //move to [
                jsonParser.nextToken();
                // loop till token equal to "]"
                while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                    System.out.println(jsonParser.getNumberValue());
                }
            }
        }



}
    public static void jsonGenrator(){
        JsonFactory jsonFactory = new JsonFactory();
        try {
            JsonGenerator generator = jsonFactory.createGenerator(new File("D:\\project\\springAll\\08.jackson\\lib\\jsonGenerator.json"), UTF8);
            generator.writeStartObject();
            generator.writeStringField("name","xiaoming");
            generator.writeNumberField("age",11);
            generator.writeBooleanField("sex",false);

            generator.writeFieldName("marks");
            generator.writeStartArray();
            generator.writeNumber(1);
            generator.writeNumber(2);
            generator.writeNumber(3);
            generator.writeEndArray();
            generator.writeEndObject();
            generator.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void  jsonTree(){
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"name\":\"Mahesh Kumar\", \"age\":21,\"verified\":false,\"marks\": [100,90,85]}";
//create tree from JSON
        try {
            JsonNode jsonNode = mapper.readTree(jsonString);
            JsonNode name = jsonNode.path("name");
            System.out.println(name.asText());
            JsonNode marks = jsonNode.path("marks");
            Iterator<JsonNode> iterator = marks.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static void json02(){
        try {
            ObjectMapper mapper = new ObjectMapper();

            Map userDataMap = new HashMap();
            UserData studentData = new UserData();
            int[] marks = {1,2,3};

            User student = new User();
            student.setPassword("10");
            student.setName("Mahesh");
            // JAVA Object
            studentData.setUser(student);
            // JAVA String
            studentData.setName("Mahesh Kumar");
            // JAVA Boolean
            studentData.setVerifie(Boolean.FALSE);
            // Array
            studentData.setMarks(marks);
            TypeReference ref = new TypeReference<UserData>() { };
            userDataMap.put("studentData1", studentData);
            mapper.writeValue(new File("student.json"), userDataMap);
            //{
            //   "studentData1":
            //	 {
            //		"student":
            //		{
            //			"name":"Mahesh",
            //			"age":10
            //      },
            //      "name":"Mahesh Kumar",
            //      "verified":false,
            //      "marks":[1,2,3]
            //   }
            //}
            userDataMap = mapper.readValue(new File("student.json"), ref);
/*
            System.out.println(userDataMap.get("studentData1").getUser());
            System.out.println(userDataMap.get("studentData1").getName());
            System.out.println(userDataMap.get("studentData1").getVerified());
            System.out.println(Arrays.toString(userDataMap.get("studentData1").getMarks()));*/
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



}
    public static void convertJson()  {
        User user = new User();
        user.setId(1);
        user.setName("zhangsan");
        user.setPassword("1234");
        int[] marks ={1,2,3};
        ObjectMapper mapper = new ObjectMapper();

        Map<String,Object> map = new HashMap<>();
        //java object
        map.put("user",user);
        map.put("marks",marks);
        map.put("Boolean",Boolean.FALSE);
        map.put("string","string");
        try {
            mapper.writeValue(new File("D:\\project\\springAll\\08.jackson\\lib\\test.json"),map);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void  testObjectMapper(){
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"name\":\"Mahesh\", \"password\":21}";
        try {
            User user = mapper.readValue(jsonString, User.class);
            System.out.println(user);
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            String s = mapper.writeValueAsString(user);
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static User readJson() {
        ObjectMapper mapper = new ObjectMapper();
        try {
           return mapper.readValue(new File("D:\\project\\springAll\\08.jackson\\lib\\user.json"), User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writerJson(User user) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("D:\\project\\springAll\\08.jackson\\lib\\user.json"), user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
