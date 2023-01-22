package com.andantonyan.apitester.common.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ApiErrorDecoder implements ErrorDecoder {
    final ObjectMapper mapper;

    ApiErrorDecoder(final ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public Exception decode(final String methodKey, final Response response) {
        ApiErrorResponse body;
        try {
            String bodyJson = Util.toString(response.body().asReader(StandardCharsets.UTF_8));
            body = mapper.readValue(bodyJson, ApiErrorResponse.class);
        } catch (IOException ex) {
            throw new IllegalStateException("Could not read the response body.", ex);
        }

        return new ApiException(response.status(), body);
    }
}
