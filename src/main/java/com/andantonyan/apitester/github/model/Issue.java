package com.andantonyan.apitester.github.model;

import lombok.Data;

import java.util.List;

@Data
public class Issue {
    String title;
    String body;
    List<String> assignees;
    int milestone;
    List<String> labels;
}
