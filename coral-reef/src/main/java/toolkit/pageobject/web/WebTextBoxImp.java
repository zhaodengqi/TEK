package toolkit.pageobject.web;

import com.google.inject.Inject;
import contract.ActionBot;
import contract.WaitMethod;
import contract.po.component.LocatorType;
import contract.po.component.WebTextBox;

public class WebTextBoxImp extends BaseWebComponent implements WebTextBox {

    private ActionBot actionBot;

    @Inject
    public WebTextBoxImp(ActionBot actionBot) {
        this.actionBot = actionBot;
    }

    @Override
    public WebTextBox setLocator(LocatorType type, String value) {
        this.locator = buildLocator(type, value);
        this.basePath = value;
        return this;
    }

    protected void waitElementVisibility() {
        actionBot.wait(locator, WaitMethod.VISIBILITY);
    }

    @Override
    public void sendKeys(String content) {
        actionBot.sendKeys(locator, content);
    }

    @Override
    public WebTextBox clear() {
        actionBot.clear(locator);
        return this;
    }

    @Override
    public String getText() {
        return actionBot.getText(locator);
    }
}
