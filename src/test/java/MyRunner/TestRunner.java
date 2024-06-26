package MyRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Features",
glue = "StepDefinitions",
monochrome = true, 

plugin = {"pretty", "html:target/index.html"})
public class TestRunner extends AbstractTestNGCucumberTests{
	

}
