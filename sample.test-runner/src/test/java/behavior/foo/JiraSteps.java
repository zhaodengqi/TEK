package behavior.foo;

import com.google.inject.Inject;
import contract.ActionBot;
import contract.TestContext;
import contract.po.PageRouter;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageobject.toolsqa.ToolsQaSignInPage;

import static org.junit.Assert.assertEquals;

public class JiraSteps {

    //    private final AtlassianSignInPage signInPage;
//    private final AtlassianHomePage homePage;
//    private final CoralReefWebDriver driver;
    private final TestContext context;
    private final PageRouter router;
    private final ActionBot actionBot;

    @Inject
    public JiraSteps(
            PageRouter router,
            ActionBot actionBot,
            TestContext context
    ) {
        this.router = router;
        this.actionBot = actionBot;
        this.context = context;
    }


    @When("I sign in to atlassian site")
    public void iSignInToAtlassianSite() {
    }

    @Given("an account is {string} | {string}")
    public void anAccountIs(String userName, String password) {
        context.put("userName", userName);
        context.put("password", password);

//        userFactory.getDefaultUser();
//        userFactory.getDefaultBlockUser();
//        userFactory.getNotExsitUser();
//        userFactory.getNotExsitUser();
//        userFactory.getVipUser(int level);
//
//        userFactory
//                .setName("Alan")
//                .setAge("37")
//                .build();
//        userFactory.loadUser("XXX.json");
    }

    @When("I sign in to Tools-QA site")
    public void i_sign_in_to_Tools_QA_site() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        ToolsQaSignInPage page = router.goTo(ToolsQaSignInPage.class);
        String title = page
                .signIn(context.get("userName"), context.get("password"))
                .getTitle();

        Assert.assertEquals("Profile", title);
    }
}
