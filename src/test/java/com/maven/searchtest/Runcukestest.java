package com.maven.searchtest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class) //cucu.class is the driving factor for connection b/w .java and .feature
@CucumberOptions(features = "src/test/resources",dryRun = false,strict = true,tags = "@sri1")//cucoptions is from cucumber

public class Runcukestest {

}
