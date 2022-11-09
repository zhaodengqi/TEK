package pageobject.petstore;

import com.google.inject.Inject;
import contract.po.PageRouter;
import contract.po.component.LocatorType;
import contract.po.component.WebButton;
import contract.po.component.WebTextBox;
import toolkit.pageobject.web.BaseWebComponent;

public class SearchBarComponent extends BaseWebComponent {

    private final PageRouter router;
    private final WebTextBox txtSearch;
    private final WebButton btnSearch;

    @Inject
    public SearchBarComponent(
            PageRouter router,
            WebTextBox txtSearch,
            WebButton btnSearch
    ) {
        this.router = router;
        //TODO: Detach parent component
        this.txtSearch = txtSearch.setLocator(LocatorType.XPATH, "//div[@id='SearchContent']//input[@name='keyword']");
        this.btnSearch = btnSearch.setLocator(LocatorType.XPATH, "//div[@id='SearchContent']//input[@name='searchProducts']");
    }

    public PetSearchListPage search(String text) {
        txtSearch.sendKeys(text);
        btnSearch.click();
        return router.build(PetSearchListPage.class);
    }
}
