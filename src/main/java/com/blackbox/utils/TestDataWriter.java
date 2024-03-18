package com.blackbox.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestDataWriter {
    static ObjectMapper objectMapper = new ObjectMapper();

    public static void writeData(Object object, String path) throws FileNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream(System.getProperty("user.dir") + "/src/test/resources/test_data/" + path);

        try {
            objectMapper.writeValue(fileOutputStream, object);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
