package com.andantonyan.apitester.common;

import feign.RequestInterceptor;
import feign.RequestTemplate;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class FeignInterceptorManager implements RequestInterceptor {
    private final Set<RequestInterceptor> interceptors = Collections.synchronizedSet(new HashSet<>());

    public void add(final RequestInterceptor interceptor) {
        interceptors.add(interceptor);
    }

    public void remove(final RequestInterceptor interceptor) {
        interceptors.remove(interceptor);
    }

    public void clear() {
        interceptors.clear();
    }

    @Override
    public void apply(final RequestTemplate requestTemplate) {
        interceptors.forEach(interceptor -> interceptor.apply(requestTemplate));
    }
}
