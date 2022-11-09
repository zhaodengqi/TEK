package pageobject.petstore;

import com.google.inject.Inject;
import contract.po.BasePageObject;
import contract.po.PageRouter;
import contract.po.component.LocatorType;
import contract.po.component.WebButton;
import contract.po.component.WebTextBox;

public class PetStoreSignInPage implements BasePageObject {
    private static final String PAGE_URL = "{petstore}/actions/Account.action";

    @Override
    public String getPageUrl() {
        return PAGE_URL;
    }

    private final PageRouter router;
    private final WebTextBox txtUserName;
    private final WebTextBox txtPassword;
    private final WebButton btnLogin;

    @Inject
    public PetStoreSignInPage(PageRouter router, WebTextBox txtUserName, WebTextBox txtPassword, WebButton btnLogin) {
        this.router = router;
        this.txtUserName = txtUserName.setLocator(LocatorType.XPATH, "//input[@name='username']");
        this.txtPassword = txtPassword.setLocator(LocatorType.XPATH, "//input[@name='password']");
        this.btnLogin = btnLogin.setLocator(LocatorType.XPATH, "//input[@value='Login']");
    }

    public PetStoreHomePage signIn(String userName, String password) {
        txtUserName.sendKeys(userName);

        txtPassword.clear();
        txtPassword.sendKeys(password);
        btnLogin.click();
        return router.build(PetStoreHomePage.class);
    }

}
