package behavior.foo;

import com.google.inject.Inject;
import contract.ActionBot;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class ActionBotGma {

//    private final ActionBot actionBot;

//    @Inject
//    public ActionBotGma(ActionBot actionBot){
//        this.actionBot = actionBot;
//    }
//    @Given("Open qatool home page")
//    public void open_qatool_home_page() throws InterruptedException {
//        //TODO: use different config build different web-driver here.
//        actionBot.openUrl("{tools-qa}");
//    }

//    @When("Click Elements")
//    public void cck_Elements() throws Exception {
//        actionBot.click(By.xpath("//*[H5='Elements']"));
////        actionBot.sendKeys(By.xpath("//*[@id=\"MenuContent\"]/a[2]"),text);
////        actionBot.click(By.xpath("(//input[@value='Google 搜索'])[2]"));
//    }

//    @Then("Elements page loaded")
//    public void elements_page_loaded() throws Exception {
//        String text = actionBot.getAttribute(By.xpath("//div[@class=\"main-header\"]"));
//        Assert.assertEquals("Wrong", "Elements", text);
//    }
}
