package e2e;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyReader {

    public static Properties loadProperties(File file) {

        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(file));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }

        return properties;
    }

    public static Map<String, String> getPropertiesMap(File file) {

        Map<String, String> map = new HashMap(loadProperties(file));
        return map;
    }
}

