package com.andantonyan.apitester.github.common;


import com.andantonyan.apitester.common.CommonModule;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

@Test
@Guice(modules = {CommonModule.class, GithubModule.class})
public abstract class AbstractGithubTest {
}
