package pageobject.petstore;

import com.google.inject.Inject;
import contract.po.BasePageObject;
import contract.po.PageRouter;
import contract.po.component.LocatorType;
import contract.po.component.WebButton;

public class PetShoppingCart implements BasePageObject {


    @Override
    public String getPageUrl() {
        return "";
    }

    private final PageRouter router;
    private final WebButton btnCheckout;

    @Inject
    public PetShoppingCart(
            PageRouter router,
            WebButton btnCheckout
    ) {
        this.router = router;
        this.btnCheckout = btnCheckout.setLocator(LocatorType.XPATH, "//a[text()='Proceed to Checkout']");
    }


    public PetShippingInformationPage proceedToCheckout() {
        btnCheckout.click();
        return router.build(PetShippingInformationPage.class);
    }
}
