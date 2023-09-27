package Excel;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/main/java/Featurefiles/excelhand.feature",
    glue = {"Excel"},
    publish=true,
    plugin = {"pretty", "html:target/cucumber-reports"}
)
public class excelruntest {
	
}
