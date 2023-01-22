package com.andantonyan.apitester.common.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Feign;
import feign.form.FormEncoder;
import feign.jackson.JacksonEncoder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiClient {
    private ObjectMapper objectMapper;
    private String basePath;
    private Feign.Builder feignBuilder;

    public ApiClient(final ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        feignBuilder = Feign.builder()
                .encoder(new FormEncoder(new JacksonEncoder(this.objectMapper)))
                .decoder(new ApiResponseDecoder(this.objectMapper))
                .errorDecoder(new ApiErrorDecoder(this.objectMapper));
    }

    public <T> T buildClient(Class<T> clientClass) {
        return feignBuilder.target(clientClass, basePath);
    }
}
