package behavior.documnet;

import com.google.inject.Inject;
import contract.ActionBot;
import contract.po.component.LocatorType;
import contract.po.component.WebButton;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class WebComponentSteps {

    private final ActionBot actionBot;
    private final WebButton domeButton;

    @Inject
    public WebComponentSteps(
            WebButton domeButton,
            ActionBot actionBot
    ) {
        this.domeButton = domeButton;
        this.actionBot = actionBot;
    }

    @Given("Inject the {string} object in the constructor")
    public void inject_the_WebButton_object_in_the_constructor(String text) {
        // There is no code here, just to show the reminder that dependency injection needs to be done.
    }
    @When("use 'click' method of object click the {string} button")
    public void click_the_button_demo(String text) throws Exception {
        domeButton.setLocator(LocatorType.XPATH,"//button[text()='Click Me']");
        domeButton.click();
    }

    @When("use 'doubleClick' method of object click the {string} button")

    public void double_click_the_button_demo(String text) {
        domeButton.setLocator(LocatorType.XPATH,"//button[text()='Double Click Me']");
        domeButton.doubleClick();
    }

    @When("use 'rightClick' method of object click the {string} button")
    public void right_click_the_button_demo(String text) {
        domeButton.setLocator(LocatorType.XPATH,"//button[text()='Right Click Me']");
        domeButton.rightClick();
    }

    @Then("verify then click action was successful")
    public void verify_then_click_action_was_successful() throws Exception {

        Assert.assertEquals("You have done a double click",actionBot.getText(By.id("doubleClickMessage")));
        Assert.assertEquals("You have done a right click",actionBot.getText(By.id("rightClickMessage")));
        Assert.assertEquals("You have done a dynamic click",actionBot.getText(By.id("dynamicClickMessage")));
    }
}
