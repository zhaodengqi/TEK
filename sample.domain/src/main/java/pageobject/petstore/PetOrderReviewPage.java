package pageobject.petstore;

import com.google.inject.Inject;
import contract.po.BasePageObject;
import contract.po.PageRouter;
import contract.po.component.LocatorType;
import contract.po.component.WebTable;

public class PetOrderReviewPage implements BasePageObject {

    private WebTable tbSummary;
    @Inject
    public PetOrderReviewPage(
            PageRouter router,
            WebTable tbSummary
    ) {
        this.tbSummary = tbSummary.setLocator(LocatorType.XPATH,"//div[@id='Catalog']/table//td[@colspan='2']/table");
    }
    @Override
    public String getPageUrl() {
        return null;
    }

    public String getTotalAmountText() {
        return tbSummary.getCellText(2, 1);
    }
}
