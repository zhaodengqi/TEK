package toolkit.pageobject.web;

import contract.po.component.LocatorType;
import org.openqa.selenium.By;

public class BaseWebComponent {
    protected By locator;
    protected String basePath;

    protected By buildLocator(LocatorType type, String value) {
        locator = null;
        switch (type) {
            case ID:
                locator = By.id(value);
                break;
            case LINK_TEXT:
                locator = By.linkText(value);
                break;
            case PARTIAL_LINK_TEXT:
                locator = By.partialLinkText(value);
                break;
            case NAME:
                locator = By.name(value);
                break;
            case TAG_NAME:
                locator = By.tagName(value);
                break;
            case XPATH:
                locator = By.xpath(value);
                break;
            case CLASS_NAME:
                locator = By.className(value);
                break;
            case CSS_SELECTOR:
                locator = By.cssSelector(value);
                break;
        }
        return locator;
    }
}
