package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "@target/FailedScenarios.txt" }, glue = { "stepdefinitions", "apphooks" }, plugin = {
		"pretty", "html:target/HtmlReportsFailedRerun.html",
		"rerun:target/FailedScenarios.txt" }, monochrome = true, dryRun = false)
public class FailedTestRunner {

}