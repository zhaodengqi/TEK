package core.custom.hooks;

import com.google.inject.Inject;
import contract.po.CoralReefWebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HookDefinitions {
    CoralReefWebDriverFactory webDriverFactory;
    @Inject
    public HookDefinitions(CoralReefWebDriverFactory webDriverFactory){
        this.webDriverFactory = webDriverFactory;
    }
    @Before("@browser")
    public void beforeScenarioForBrowser(Scenario scenario) {
        webDriverFactory.initialize();
        scenario.log("Hook action: web-driver factory initialize");
    }

    @After("@browser")
    public void afterScenarioForBrowser(Scenario scenario) {
        webDriverFactory.dispose();
        scenario.log("Hook action: web-driver factory dispose");
    }
}
