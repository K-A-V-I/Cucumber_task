package facebook;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions(
		features = {"src/main/java/Featurefiles/fb.feature"},
		publish=true,
		glue = {"facebook"}) 

public class runtest { }