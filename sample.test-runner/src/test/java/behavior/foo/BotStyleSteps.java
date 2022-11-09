package behavior.foo;

import com.google.inject.Inject;
import contract.ActionBot;
import contract.WaitMethod;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class BotStyleSteps {
    private ActionBot actionBot;

    @Inject
    public BotStyleSteps(
            ActionBot actionBot) {
        this.actionBot = actionBot;
    }

    @Given("open the url {string}")
    public void openTheUrlUrl(String url) {
        actionBot.openUrl(url);
        // factory.getDriverInstance().get(url);
    }

    @When("input {string} into text-box that default text is {string}")
    public void inputIntoTextBox(String text, String defaultText) {
        By locator = By.xpath(String.format("//input[@placeholder='%s']", defaultText));
        actionBot.sendKeys(locator, text);

    }

    @Then("the password textbox is display")
    public void thePasswordTextboxIsDisplay() {
        actionBot.wait(By.xpath("//input[@placeholder='输入密码']"), WaitMethod.VISIBILITY);
    }


    @When("click the {string} button")
    public void clickTheButton(String buttonText) {
        String xpath = String.format("//button[text()='%s']", buttonText);
        actionBot.click(By.xpath(xpath));
    }

    @Then("the page redirected to {string}")
    public void thePageRedirectedTo(String url) {
        actionBot.waitUrlContains(url);
    }

    @Then("some check")
    public void some_check() {
    }
}
