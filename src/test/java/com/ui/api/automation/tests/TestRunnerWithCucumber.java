package com.ui.api.automation.tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/features"}, glue = {"com.ui.api.automation.stepdefination"}, plugin = {"pretty", "html:target/cucumber-reports.html"})
public class TestRunnerWithCucumber extends AbstractTestNGCucumberTests {
}
