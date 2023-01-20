package com.andantonyan.apitester.common;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.naharoo.commons.testingtoolkit.random.RandomizationSupport;
import com.naharoo.commons.testingtoolkit.random.Randomizer;
import lombok.SneakyThrows;

import java.util.Properties;

public class CommonModule extends AbstractModule {

    @SneakyThrows
    @Override
    protected void configure() {
        Names.bindProperties(binder(), getProperties());
        bind(ObjectMapper.class).toInstance(createObjectMapper());
        bind(Randomizer.class).toInstance(RandomizationSupport.randomizer());
    }

    @SneakyThrows
    private Properties getProperties() {
        final Properties properties = new Properties();
        properties.load(this.getClass().getClassLoader().getResourceAsStream("application.properties"));
        return properties;
    }

    static private ObjectMapper createObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
        objectMapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.disable(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.setDateFormat(new RFC3339DateFormat());
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.registerModule(new ParameterNamesModule());
        return objectMapper;
    }
}
