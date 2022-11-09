package toolkit.pageobject.web;

import com.google.inject.Inject;
import contract.ActionBot;
import contract.po.component.LocatorType;
import contract.po.component.WebSelect;

public class WebSelectImp extends BaseWebComponent implements WebSelect {

    @Override
    public WebSelect setLocator(LocatorType type, String value) {
        this.locator = buildLocator(type, value);
        this.basePath = value;
        return this;
    }

    private final ActionBot actionBot;

    @Inject
    public WebSelectImp(ActionBot actionBot) {
        this.actionBot = actionBot;
    }

    @Override
    public void selectByIndex(int index) {
        actionBot.selectByIndex(locator, index);
    }

    @Override
    public void selectByValue(String value) {
        actionBot.selectByValue(locator, value);
    }

    @Override
    public void selectByVisibleText(String text) {
        actionBot.selectByVisibleText(locator, text);
    }
}
