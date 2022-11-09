package pageobject.petstore;

import com.google.inject.Inject;
import contract.ActionBot;
import contract.po.BasePageObject;
import contract.po.PageRouter;
import contract.po.component.LocatorType;
import contract.po.component.WebTable;

public class PetSearchDetailPage implements BasePageObject {


    @Override
    public String getPageUrl() {
        return "";
    }

    private final PageRouter router;

    private final WebTable tbSummary;

    @Inject
    public PetSearchDetailPage(
            PageRouter router,
            ActionBot actionBot,
            WebTable tbSummary
    ) {
        this.router = router;
        this.tbSummary = tbSummary.setLocator(LocatorType.XPATH, "//div[@id='Catalog']/table");
    }


    public PetShoppingCart addShoppingCartByPetDescription(String description) {
        int iRow = 1;
        while (tbSummary.isExist(iRow, 1)) {
            if (description.equals(tbSummary.getCellText(iRow, 3))) {
                tbSummary.clickLinkInCell(iRow, 5);
                break;
            }
            iRow++;
        }
        //TODO: there is a bug???
        return router.build(PetShoppingCart.class);
    }
}
