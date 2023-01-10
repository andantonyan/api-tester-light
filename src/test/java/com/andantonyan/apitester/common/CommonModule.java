package com.andantonyan.apitester.common;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import lombok.SneakyThrows;

import java.util.Properties;

public class CommonModule extends AbstractModule {
    @SneakyThrows
    @Override
    protected void configure() {
        final Properties properties = new Properties();
        properties.load(this.getClass().getClassLoader().getResourceAsStream("application.properties"));
        Names.bindProperties(binder(), properties);
    }
}

