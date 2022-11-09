package contract.po.component;

public interface WebButton {
    void click();

    String getText();

    WebButton setLocator(LocatorType type, String value);

    void doubleClick();

    void rightClick();
}
