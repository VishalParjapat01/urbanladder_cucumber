package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions( features = "D:\\Elevate\\Selenium\\practice\\Cucumber_URBANLEADER\\src\\test\\resources\\Features\\Search.feature",
glue = "Defination",
plugin = {"pretty",
		"html:cucumber-reports.html"}
		)
public class Runner extends AbstractTestNGCucumberTests{
	

}
