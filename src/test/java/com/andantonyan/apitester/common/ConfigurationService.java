package com.andantonyan.apitester.common;

import lombok.SneakyThrows;

import java.util.Map;
import java.util.Properties;

/**
 * Created by Andranik Antonyan
 * Date: 1/10/23
 * Time: 1:15 PM
 */
public class ConfigurationService {
    @SneakyThrows
    Map<Object, Object> getRawAll() {
        final Properties properties = new Properties();
        properties.load(this.getClass().getClassLoader().getResourceAsStream("application.properties"));
        return properties;
    }

    public Object getRaw(Object key) {
        return getRawAll().get(key);
    }
}
