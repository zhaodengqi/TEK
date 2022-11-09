package pageobject.petstore;

import com.google.inject.Inject;
import contract.po.BasePageObject;

public class PetStoreHomePage implements BasePageObject {
    private static final String PAGE_URL = "{petstore}/actions/Catalog.action";

    @Override
    public String getPageUrl() {
        return PAGE_URL;
    }

    private SearchBarComponent compSearchBar;

    @Inject
    public PetStoreHomePage(
            SearchBarComponent compSearchBar
    ) {
        this.compSearchBar = compSearchBar;
    }

    public PetSearchListPage search(String text) {
        return this.compSearchBar.search((text));
    }

}
