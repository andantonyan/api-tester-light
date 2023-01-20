package com.andantonyan.apitester.github.common;

import com.andantonyan.apitester.common.client.ApiClient;
import com.andantonyan.apitester.common.client.InterceptorManager;
import com.andantonyan.apitester.github.client.GitHubClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import javax.inject.Named;
import javax.inject.Singleton;

public class GithubModule extends AbstractModule {
    @Provides
    @Singleton
    private InterceptorManager getInterceptorManager() {
        return new InterceptorManager();
    }

    @Provides
    @Singleton
    private ApiClient getApiClient(
            final ObjectMapper objectMapper,
            final InterceptorManager interceptorManager,
            @Named("github.url") final String communicationsUrl
    ) {
        final ApiClient apiClient = new ApiClient(objectMapper);
        apiClient.setBasePath(communicationsUrl);
        apiClient.getFeignBuilder().requestInterceptor(interceptorManager);
        return apiClient;
    }

    @Provides
    @Singleton
    private GitHubClient getGitHubClient(final ApiClient apiClient) {
        return apiClient.buildClient(GitHubClient.class);
    }
}


