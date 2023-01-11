package com.andantonyan.apitester.common;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.naharoo.commons.testingtoolkit.random.RandomizationSupport;
import com.naharoo.commons.testingtoolkit.random.Randomizer;
import lombok.SneakyThrows;

public class CommonModule extends AbstractModule {
    @SneakyThrows
    @Override
    protected void configure() {
        final ConfigurationService configurationService = new ConfigurationService();
        Names.bindProperties(binder(), configurationService.getRawAll());
        bind(ConfigurationService.class).toInstance(configurationService);
        bind(Randomizer.class).toInstance(RandomizationSupport.randomizer());
    }
}
