package Excelhandle;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions(
		features = {"src/main/java/Featurefiles/Excel.feature"},
		publish=true,
		glue = {"Excelhandle"},
		plugin = {"pretty", "html:target/cucumber-reports"}) 

public class exceltest { }