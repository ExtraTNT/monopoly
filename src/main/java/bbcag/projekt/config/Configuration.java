package bbcag.projekt.config;

import java.io.IOException;
import java.util.Properties;

/** Configuration
 * singleton class to load the config from a file
 */
public class Configuration {

    private static Configuration instance;
    private final Properties PROPERTIES;

    public static Configuration getInstance() {
        if (instance == null) {
            instance = new Configuration();
        }
        return instance;
    }

    /** Configuration
     * loads the configuration form the config.properties file
     */
    private Configuration() {
        PROPERTIES = new Properties();
        try {
            PROPERTIES.load(getClass().getResourceAsStream("/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**get
     * @param key the property name
     * @return the value of the key
     */
    public String get(String key) {
        return (String) PROPERTIES.get(key);
    }
}
