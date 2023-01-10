package com.andantonyan.apitester.common;

import lombok.SneakyThrows;

import java.util.Properties;

public class ConfigurationService {
    @SneakyThrows
    Properties getRawAll() {
        final Properties properties = new Properties();
        properties.load(this.getClass().getClassLoader().getResourceAsStream("application.properties"));
        return properties;
    }

    public Object getRaw(final Object key) {
        return getRawAll().get(key);
    }
}
