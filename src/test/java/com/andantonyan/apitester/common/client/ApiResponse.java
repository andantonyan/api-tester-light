package com.andantonyan.apitester.common.client;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class ApiResponse<T> {
  int statusCode;
  Map<String, List<String>> headers;
  T data;
}