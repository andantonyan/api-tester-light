package com.andantonyan.apitester.github.client;

import com.andantonyan.apitester.github.model.Contributor;
import com.andantonyan.apitester.github.model.Issue;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface GitHubClient {
    @RequestLine("GET /repos/{owner}/{repo}/contributors")
    List<Contributor> contributors(@Param("owner") String owner, @Param("repo") String repo);

    @RequestLine("POST /repos/{owner}/{repo}/issues")
    void createIssue(Issue issue, @Param("owner") String owner, @Param("repo") String repo);
}
