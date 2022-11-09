package behavior.foo;

import com.google.inject.Inject;
import contract.ActionBot;
import contract.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;


public class BuydogSteps {
    private final ActionBot actionBot;

    @Inject
    public BuydogSteps(
            ActionBot actionBot) {

        this.actionBot = actionBot;

    }

    @Given("Open Petstore Login page {string}")
    public void Open_Petstore_Login_page(String url) throws Exception {
        actionBot.openUrl("{petstore}/actions/Account.action;jsessionid=7BAAAD86BEDBEF33D99886C22944830C?signonForm=");
    }


    @Given("Input {string} and {string}")
    public void Input_and(String userName, String password) throws Exception {
        actionBot.clear(By.xpath("//input[@name='password']"));
        actionBot.sendKeys(By.xpath("//input[@name='username']"), userName);
        actionBot.sendKeys(By.xpath("//input[@name='password']"), password);
    }

    @Given("Click Login Button")
    public void Click_Login_Button() throws Exception {
        actionBot.click(By.xpath("//input[@name='signon']"));
    }

    @When("Wait until the main page return")
    public void Wait_until_the_main_page_return() throws Exception {
        actionBot.waitUrlContains("Catalog.action");
    }

    @When("Search and add bulldog to purchase")
    public void Search_and_add_bulldog_to_purchase() throws Exception {
        actionBot.sendKeys(By.xpath("//input[@name='keyword']"), "bulldog");
        actionBot.click(By.xpath("//input[@name='searchProducts']"));
        actionBot.click(By.xpath("//div[@id=\"Catalog\"]//tr[2]//td[1]//a"));
        actionBot.click(By.xpath("//div[@id=\"Catalog\"]//tr[2]//td[5]//a"));
        actionBot.click(By.xpath("//a[text()='Proceed to Checkout']"));
    }

    @When("Check the content of the payment information")
    public void Check_the_content_of_the_payment_information() throws Exception {
//        String text = actionBot.getAttribute(By.xpath("//select[@name=\"order.cardType\"]//option[@selected=\"selected\" "));
//        Assert.assertEquals("Visa",text, );


        actionBot.click(By.xpath("//input[@name=\"newOrder\"]"));
        actionBot.click(By.xpath("//a[text()=\"Confirm\"]"));
    }

    @Then("check the order amount")
    public void check_the_order_amount() throws Exception {
        String text = actionBot.getAttribute(By.xpath("//th[@colspan=\"5\"]"));
        Assert.assertEquals("wrong", "Total: $18.50", text);
    }
}
