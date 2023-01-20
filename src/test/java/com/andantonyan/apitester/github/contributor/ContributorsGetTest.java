package com.andantonyan.apitester.github.contributor;

import com.andantonyan.apitester.common.client.InterceptorManager;
import com.andantonyan.apitester.github.client.GitHubClient;
import com.andantonyan.apitester.github.common.AbstractGithubTest;
import com.andantonyan.apitester.github.model.Contributor;
import com.naharoo.commons.testingtoolkit.random.Randomizer;
import lombok.extern.java.Log;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isA;
import static org.hamcrest.Matchers.notNullValue;

@Log
public class ContributorsGetTest extends AbstractGithubTest {
    @Inject
    @Named("github.test.owner")
    private String githubTestOwner;

    @Inject
    @Named("github.test.repo")
    private String githubTestRepo;

    @Inject
    private Randomizer randomizer;

    @Inject
    private InterceptorManager interceptorManager;

    @Inject
    private GitHubClient gitHubClient;

    @BeforeMethod
    public void setUp() {
        interceptorManager.add(tpl -> tpl.header("authorization", randomizer.string()));
    }

    @AfterMethod
    public void tearDown() {
        interceptorManager.clear();
    }

    @Test
    public void shouldGetContributorsList() {
        List<Contributor> contributors = gitHubClient.contributors(githubTestOwner, githubTestRepo);
        assertThat(contributors, notNullValue());
        assertThat(contributors, isA(List.class));
    }
}