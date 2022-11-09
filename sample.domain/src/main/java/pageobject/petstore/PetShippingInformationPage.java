package pageobject.petstore;

import com.google.inject.Inject;
import contract.ActionBot;
import contract.po.BasePageObject;
import contract.po.PageRouter;
import contract.po.component.LocatorType;
import contract.po.component.WebButton;
import contract.po.component.WebSelect;
import contract.po.component.WebTextBox;

import java.util.Map;

public class PetShippingInformationPage implements BasePageObject {
    private final PageRouter router;
    private final WebSelect selectCardType;
    private final WebTextBox tbCardNumber;
    private final WebTextBox tbExpiryDate;
    private final WebTextBox tbFirstName;
    private final WebTextBox tbLastName;
    private final WebTextBox tbAddress1;
    private final WebTextBox tbAddress2;
    private final WebTextBox tbCity;
    private final WebTextBox tbState;
    private final WebTextBox tbZip;
    private final WebTextBox tbCountry;
    private final WebButton btnContinue;

    @Inject
    public PetShippingInformationPage(
            ActionBot actionBot,
            PageRouter router,
            WebSelect selectCardType,
            WebTextBox tbCardNumber,
            WebTextBox tbExpiryDate,
            WebTextBox tbFirstName,
            WebTextBox tbLastName,
            WebTextBox tbAddress1,
            WebTextBox tbAddress2,
            WebTextBox tbCity,
            WebTextBox tbState,
            WebTextBox tbZip,
            WebTextBox tbCountry,
            WebButton btnContinue
    ) {
        this.router = router;
        this.selectCardType = selectCardType.setLocator(LocatorType.XPATH, "//select[@name='order.cardType']");
        this.tbCardNumber = tbCardNumber.setLocator(LocatorType.XPATH, "//input[@name='order.creditCard']");
        this.tbExpiryDate = tbExpiryDate.setLocator(LocatorType.XPATH, "//input[@name='order.expiryDate']");
        this.tbFirstName = tbFirstName.setLocator(LocatorType.XPATH, "//input[@name='order.billToFirstName']");
        this.tbLastName = tbLastName.setLocator(LocatorType.XPATH, "//input[@name='order.billToLastName']");
        this.tbAddress1 = tbAddress1.setLocator(LocatorType.XPATH, "//input[@name='order.billAddress1']");
        this.tbAddress2 = tbAddress2.setLocator(LocatorType.XPATH, "//input[@name='order.billAddress2']");
        this.tbCity = tbCity.setLocator(LocatorType.XPATH, "//input[@name='order.billCity']");
        this.tbState = tbState.setLocator(LocatorType.XPATH, "//input[@name='order.billState']");
        this.tbZip = tbZip.setLocator(LocatorType.XPATH, "//input[@name='order.billZip']");
        this.tbCountry = tbCountry.setLocator(LocatorType.XPATH, "//input[@name='order.billCountry']");
        this.btnContinue = btnContinue.setLocator(LocatorType.XPATH, "//input[@value='Continue']");
    }

    @Override
    public String getPageUrl() {
        return null;
    }

    public PetShippingInformationPage fillShippingInformation(Map<String, String> map) {
        selectCardType.selectByVisibleText(map.get("CardType")); //Card Type
        tbCardNumber.clear().sendKeys(map.get("CardNumber"));   //Card Number
        tbExpiryDate.clear().sendKeys(map.get("ExpiryDate")); //Expiry Date
        tbFirstName.clear().sendKeys(map.get("FirstName")); //billToFirstName
        tbLastName.clear().sendKeys(map.get("LastName")); //billToLastName
        tbAddress1.clear().sendKeys(map.get("Address1")); //Address1
        tbAddress2.clear().sendKeys(map.get("Address2")); //Address2
        tbCity.clear().sendKeys(map.get("City"));  //billCity
        tbState.clear().sendKeys(map.get("State")); //State
        tbZip.clear().sendKeys(map.get("Zip")); //Zip
        tbCountry.clear().sendKeys(map.get("Country")); //Country
        return this;
    }

    public PetOrderConfirmPage submitShippingInformation() {
        btnContinue.click();
        return router.build(PetOrderConfirmPage.class);
    }
}