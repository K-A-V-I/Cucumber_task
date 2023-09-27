package amazon;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/Featurefiles/amazon.feature",
        glue = {"amazon"},
        publish=true,
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class amazonruntest {
}
