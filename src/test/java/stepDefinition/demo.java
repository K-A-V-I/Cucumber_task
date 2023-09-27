package stepDefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = {"src/main/java/Featurefiles/google.feature"},
	publish=true,
	glue = {"stepDefinition"}
		)


public class demo {

}
