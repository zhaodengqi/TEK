package behavior.foo;

import com.google.inject.Inject;
import core.container.ServiceLocator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.net.MalformedURLException;

public class CalculatorSteps {
    private ServiceLocator factory;

    @Inject
    public CalculatorSteps(ServiceLocator factory) {
        this.factory = factory;
    }
    @Given("the first number is {int}")
    public void GivenTheFirstNumberIs(int number) {
        //TODO: implement arrange (precondition) logic
        System.out.print(factory.hashCode());

    }

    @Given("the second number is {int}")
    public void GivenTheSecondNumberIs(int number) {
        //TODO: implement arrange (precondition) logic
        System.out.print(factory.hashCode());

    }

    @When("the two numbers are added")
    public void WhenTheTwoNumbersAreAdded() {
        //TODO: implement act (action) logic
        System.out.print(factory.hashCode());

    }

    @Then("the result should be {int}")
    public void ThenTheResultShouldBe(int result) throws MalformedURLException, ClassNotFoundException {
        //TODO: implement assert (verification) logic
        System.out.print(factory.hashCode());

    }
}