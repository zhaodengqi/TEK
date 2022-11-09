package contract.po.component;


public interface WebSelect {
    void selectByIndex(int index);

    void selectByValue(String value);

    void selectByVisibleText(String text);

    WebSelect setLocator(LocatorType type, String value);
}
