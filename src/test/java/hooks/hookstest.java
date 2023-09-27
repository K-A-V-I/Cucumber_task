package hooks;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions(
		features = {"src/main/java/Featurefiles/hooks.feature"},
		publish=true,
		glue = {"hooks"}) 

public class hookstest { }