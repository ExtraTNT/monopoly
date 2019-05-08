package bbcag.projekt.config;

import java.io.IOException;
import java.util.Properties;

public class Confiuration {

    private static Confiuration instance;

    private final Properties properties;

    private Confiuration() {
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

    public static Confiuration getInstance() {
        if (instance == null) {
            instance = new Confiuration();
        }
        return instance;
    }
}
