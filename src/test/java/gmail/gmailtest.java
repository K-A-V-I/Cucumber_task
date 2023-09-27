package gmail;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions(
		features = {"src/main/java/Featurefiles/gmail.feature"},
		publish=true,
		glue = {"gmail"}) 

public class gmailtest { }