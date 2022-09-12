package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;


public class FileReader {

    public Profile getDataFromFile(File file) {
        HashMap <String, String> map = new HashMap<>();
        String input;

        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
        while ((input = reader.readLine()) != null) {
            String[] keyValuePair = input.split(": ", 2);
            String key = keyValuePair[0];
            String value = keyValuePair[1];
            map.put(key, value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Profile(map.get("Name"),
                Integer.valueOf(map.get("Age")),
                map.get("Email"),
                Long.valueOf(map.get("Phone")));
    }
}
