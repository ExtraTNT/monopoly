package bbcag.projekt.config;

import java.io.IOException;
import java.util.Properties;

public class Configuration {

    private static Configuration instance;

    private final Properties properties;

    private Configuration() {
        properties = new Properties();

        try {
            properties.load(getClass().getResourceAsStream("/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String get(String key){
        return (String) properties.get(key);
    }

    public static Configuration getInstance() {
        if (instance == null) {
            instance = new Configuration();
        }
        return instance;
    }
}
