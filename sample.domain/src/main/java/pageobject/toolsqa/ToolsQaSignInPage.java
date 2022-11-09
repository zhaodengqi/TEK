package pageobject.toolsqa;

import com.google.inject.Inject;
import contract.ActionBot;
import contract.po.BasePageObject;
import contract.po.PageRouter;
import contract.po.component.WebButton;
import contract.po.component.WebTextBox;

import static contract.po.component.LocatorType.XPATH;

public class ToolsQaSignInPage implements BasePageObject {

    private final ActionBot actionBot;
    private final PageRouter router;
    private final WebButton btnLoginSubmit;
    private final WebTextBox txtUserName;
    private final WebTextBox txtPassword;

    private static final String PAGE_URL = "{tools-qa}/login";

    @Override
    public String getPageUrl() {
        return PAGE_URL;
    }

    @Inject
    public ToolsQaSignInPage(
            ActionBot actionBot,
            PageRouter router,
            WebButton btnLoginSubmit,
            WebTextBox txtUserName,
            WebTextBox txtPassword
    ) {
        this.actionBot = actionBot;
        this.router = router;
        this.btnLoginSubmit = btnLoginSubmit.setLocator(XPATH, "//button[@id='login']");
        this.txtUserName = txtUserName.setLocator(XPATH, "//input[@id='userName']");
        this.txtPassword = txtPassword.setLocator(XPATH, "//input[@id='password']");
    }

    public ToolsQaProfilePage signIn(String userName, String password) throws Exception {
        txtUserName.sendKeys(userName);
        txtPassword.sendKeys(password);
        btnLoginSubmit.click();
        actionBot.waitUrlContains("{tools-qa}/profile");
        return router.build(ToolsQaProfilePage.class);
    }

}
