package pageobject.petstore;

import com.google.inject.Inject;
import contract.po.BasePageObject;
import contract.po.PageRouter;
import contract.po.component.LocatorType;
import contract.po.component.WebButton;

public class PetOrderConfirmPage implements BasePageObject {
    private final WebButton btnConfirm;
    private final PageRouter router;

    @Inject
    public PetOrderConfirmPage(
            PageRouter router,
            WebButton btnConfirm
    ) {

        this.router = router;
        this.btnConfirm = btnConfirm.setLocator(LocatorType.XPATH, "//a[text()='Confirm']");
    }

    @Override
    public String getPageUrl() {
        return null;
    }

    public PetOrderReviewPage confirmOrder() {
        btnConfirm.click();
        return router.build(PetOrderReviewPage.class);
    }
}
