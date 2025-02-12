package org.onboard.collections.properties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private Properties config;

    public Config() {
        this.config = new Properties();
        reset();
    }

    public void reset() {
        try {
            FileInputStream configFile = new FileInputStream("src/main/resources/config.properties");
            Properties tempConfig = new Properties();
            tempConfig.load(configFile);
            configFile.close();

            String defaultFilenames = tempConfig.getProperty("default.filenames");
            if (defaultFilenames != null) {
                String[] filenames = defaultFilenames.split(",");

                for (int i = filenames.length - 1; i >= 0; i--) {
                    String filename = filenames[i].trim();
                    FileInputStream defaultFile = new FileInputStream("src/main/resources/"+filename + ".properties");
                    Properties defaultProps = new Properties();
                    defaultProps.load(defaultFile);
                    defaultFile.close();

                    config.putAll(defaultProps);
                }
            }

            config.load(new FileInputStream("src/main/resources/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String get(String key) {
        return config.getProperty(key);
    }

    public void set(String key, String value) {
        config.setProperty(key, value);
    }

    public void save() {
        try {
            FileOutputStream configFile = new FileOutputStream("src/main/resources/config.properties");
            config.store(configFile, null);
            configFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void remove(String key) {
        if (config.containsKey(key)) {
            config.remove(key);
        }
    }
}



