package com.blackbox.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class TestDataReader {

    static ObjectMapper mapper = new ObjectMapper();
    static FileInputStream fileInputStream;

    public static <T> T readData(String path, Class<T> valueType) throws IOException {
        try {
            fileInputStream = new FileInputStream(System.getProperty("user.dir") +"/src/test/resources/test_data/" + path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return mapper.readValue(fileInputStream, valueType);
    }
    public static <T> List<T> readDataList(String path, Class<T> valueType) throws IOException {
        List<T> result = null;
        try {
            CollectionType listType = mapper.getTypeFactory().constructCollectionType(List.class, valueType);
            result = mapper.readValue(new File(System.getProperty("user.dir") + "/src/test/resources/test_data/" + path), listType);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}
