package contract.po.component;

public interface WebTextBox {
    void sendKeys(String content);

    WebTextBox clear();

    String getText();

    WebTextBox setLocator(LocatorType type, String value);
}
