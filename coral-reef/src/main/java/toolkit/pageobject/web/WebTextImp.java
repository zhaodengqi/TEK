package toolkit.pageobject.web;

import com.google.inject.Inject;
import contract.ActionBot;
import contract.po.component.LocatorType;
import contract.po.component.WebText;

public class WebTextImp extends BaseWebComponent implements WebText {

    private ActionBot actionBot;

    @Inject
    public WebTextImp(ActionBot actionBot) {
        this.actionBot = actionBot;
    }

    @Override
    public WebText setLocator(LocatorType type, String value) {
        this.locator = buildLocator(type, value);
        this.basePath = value;
        return this;
    }

    public String getText() {
        return actionBot.getText(locator);
    }
}
