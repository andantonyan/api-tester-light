package com.andantonyan.apitester.github.contributor;

import com.andantonyan.apitester.github.client.GitHubClient;
import com.andantonyan.apitester.github.common.AbstractGithubTest;
import com.andantonyan.apitester.github.model.Contributor;
import lombok.extern.java.Log;
import org.testng.annotations.Test;

import javax.inject.Inject;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isA;
import static org.hamcrest.Matchers.notNullValue;


@Log
public class ContributorsGetTest extends AbstractGithubTest {

    @Inject
    private GitHubClient gitHubClient;

    @Test
    public void shouldGetContributorsList() {
        List<Contributor> contributors = gitHubClient.contributors("OpenFeign", "feign");
        assertThat(contributors, notNullValue());
        assertThat(contributors, isA(List.class));
    }
}