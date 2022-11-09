package core;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","html:target/cucumber-report.html"} ,
        features = "src/test/resources/test-suite",
        glue = {"behavior","core.custom.hooks"},
        tags = "@debug",
        objectFactory = core.container.ComponentObjectFactory.class
)
public class RunCucumberTest {
}
