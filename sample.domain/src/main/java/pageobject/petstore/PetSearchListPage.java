package pageobject.petstore;

import com.google.inject.Inject;
import contract.ActionBot;
import contract.po.BasePageObject;
import contract.po.PageRouter;
import contract.po.component.LocatorType;
import contract.po.component.WebTable;

public class PetSearchListPage implements BasePageObject {
    private static final String PAGE_URL = "{petstore}/actions/Catalog.action";

    @Override
    public String getPageUrl() {
        return PAGE_URL;
    }

    private final PageRouter router;
    private final WebTable tbSearchList;

    @Inject
    public PetSearchListPage(
            PageRouter router,
            ActionBot actionBot,
            WebTable tbSearchList
    ) {
        this.router = router;
        this.tbSearchList = tbSearchList.setLocator(LocatorType.XPATH, "//div[@id='Catalog']/table");
    }


    public PetSearchDetailPage selectPetByIndex(int index) {
        tbSearchList.clickLinkInCell(index, 1);
        return router.build(PetSearchDetailPage.class);
    }
}
