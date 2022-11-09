package behavior.toolsqa;

import com.google.inject.Inject;
import contract.ActionBot;
import contract.WaitMethod;
import contract.po.CoralReefWebDriverFactory;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestDemoStep {

    private ActionBot actionBot;

    @Inject
    public TestDemoStep(ActionBot actionBot){
        this.actionBot = actionBot;
    }
    @Given("open web site google")
    public void open_web_site_google() throws InterruptedException {
        //TODO: use different config build different web-driver here.
        actionBot.openUrl("{google}");
    }

    @When("input {string} in search text box")
    public void input_in_search_text_box(String text) throws Exception {

        actionBot.sendKeys(By.xpath("//input[@name='q']"),text);
        actionBot.click(By.xpath("(//input[@value='Google 搜索'])[2]"));
    }

    @Then("check search result")
    public void check_search_result() throws Exception {
        String text = actionBot.getText(By.xpath("(//a/br/following::h3[@class='LC20lb MBeuO DKV0Md'])[1]"));
        Assert.assertTrue(text.contains("Auto"));
    }
}
