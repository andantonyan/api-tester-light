package com.andantonyan.apitester.github.common;

import com.andantonyan.apitester.common.ConfigurationService;
import com.andantonyan.apitester.common.FeignInterceptorDecorator;
import com.andantonyan.apitester.github.client.GitHubClient;
import com.google.inject.AbstractModule;
import feign.Feign;
import feign.gson.GsonDecoder;

import javax.inject.Inject;

public class GithubModule extends AbstractModule {
    @Inject
    ConfigurationService configurationService;

    @Override
    protected void configure() {
        final FeignInterceptorDecorator feignInterceptorDecorator = new FeignInterceptorDecorator();
        final GitHubClient github = Feign.builder()
                .requestInterceptor(feignInterceptorDecorator)
                .decoder(new GsonDecoder())
                .target(GitHubClient.class, (String) configurationService.getRaw("github.url"));
        bind(FeignInterceptorDecorator.class).toInstance(feignInterceptorDecorator);
        bind(GitHubClient.class).toInstance(github);
    }
}


