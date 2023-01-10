package com.andantonyan.apitester.common;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.name.Names;
import com.naharoo.commons.testingtoolkit.random.RandomizationSupport;
import com.naharoo.commons.testingtoolkit.random.Randomizer;
import lombok.SneakyThrows;

public class CommonModule extends AbstractModule {
    final ConfigurationService configurationService;

    @Inject
    public CommonModule(final ConfigurationService configurationService) {
        this.configurationService = configurationService;
    }

    @SneakyThrows
    @Override
    protected void configure() {
        Names.bindProperties(binder(), configurationService.getRawAll());
        bind(Randomizer.class).toInstance(RandomizationSupport.randomizer());
    }
}

