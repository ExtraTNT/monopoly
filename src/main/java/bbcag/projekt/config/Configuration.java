package bbcag.projekt.config;

import java.io.IOException;
import java.util.Properties;

public class Configuration {

    private static Configuration instance;
    private final Properties PROPERTIES;

    public static Configuration getInstance() {
        if (instance == null) {
            instance = new Configuration();
        }
        return instance;
    }

    private Configuration() {
        PROPERTIES = new Properties();
        try {
            PROPERTIES.load(getClass().getResourceAsStream("/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String get(String key) {
        return (String) PROPERTIES.get(key);
    }
}
