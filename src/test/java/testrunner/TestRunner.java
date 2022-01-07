package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/features" }, glue = { "stepdefinitions",
		"apphooks" }, plugin = { "pretty", "html:target/CucumberHtmlReports.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "timeline:test-output-thread/",
				"rerun:target/FailedScenarios.txt" }, monochrome = true, dryRun = false)
public class TestRunner {

}