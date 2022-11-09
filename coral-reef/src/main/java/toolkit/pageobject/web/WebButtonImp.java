package toolkit.pageobject.web;

import com.google.inject.Inject;
import contract.ActionBot;
import contract.po.component.LocatorType;
import contract.po.component.WebButton;

public class WebButtonImp extends BaseWebComponent implements WebButton {

    private ActionBot actionBot;

    @Inject
    public WebButtonImp(ActionBot actionBot) {
        this.actionBot = actionBot;
    }

    @Override
    public WebButton setLocator(LocatorType type, String value) {
        this.locator = buildLocator(type, value);
        this.basePath = value;
        return this;
    }

    @Override
    public void doubleClick() {
        actionBot.doubleClick(locator);
    }

    @Override
    public void rightClick() {
        actionBot.rightClick(locator);
    }

    public void click() {
        actionBot.click(locator);
    }

    public String getText() {
        return actionBot.getText(locator);
    }
}
