package com.andantonyan.apitester.github.common;


import com.andantonyan.apitester.common.CommonModule;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

@Test
@Guice(modules = {GithubModule.class, CommonModule.class})
public abstract class AbstractGithubTest {
}
