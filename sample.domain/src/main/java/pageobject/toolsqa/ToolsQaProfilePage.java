package pageobject.toolsqa;

import com.google.inject.Inject;
import contract.po.BasePageObject;
import contract.po.component.LocatorType;
import contract.po.component.WebText;

public class ToolsQaProfilePage implements BasePageObject {

    private WebText lblTitle;

    private static final String PAGE_URL = "{tools-qa}/profile";
    @Override
    public String getPageUrl() {
        return PAGE_URL;
    }

    @Inject
    public ToolsQaProfilePage(
            WebText lblTitle
    ) {
        this.lblTitle = lblTitle.setLocator(LocatorType.XPATH, "//div[@id='app']//div[@class='main-header']");
    }

    public String getTitle() throws InterruptedException {
        Thread.sleep(1000);
        return lblTitle.getText();
    }


}
