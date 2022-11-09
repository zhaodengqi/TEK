package behavior.coralreef;

import contract.CoralReefConfiguration;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import toolkit.CoralReefConfigurationImp;

@ScenarioScoped
public class ConfigurationSteps {
    private String fileName;
    private String factValue;

    @Given("the config file name is {string}")
    public void the_config_file_name_is(String name) {
        fileName = name;
    }

    @When("invoking function getOption with parameter is {string}")
    public void invoking_function_getOption_with_parameter_is(String key) {
        CoralReefConfiguration configuration = new CoralReefConfigurationImp();
        factValue = configuration.getOption(key);
    }

    @When("invoking function getSubOption with parameter is {string} | {string}")
    public void invoking_function_getSubOption_with_parameter_is(String key, String subKey) {
        CoralReefConfiguration configuration = new CoralReefConfigurationImp();
        factValue = configuration.getSubOption(key,subKey);
    }


    @Then("the result should be {string}")
    public void the_result_should_be(String expectedValue) {
        Assert.assertEquals(factValue, expectedValue);
    }

}
