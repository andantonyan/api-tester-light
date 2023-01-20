package com.andantonyan.apitester.common.client;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiException extends Exception {
    final int status;
    final ApiErrorResponse body;
}
