package contract.po;

import org.openqa.selenium.WebDriver;

//@ImplementedBy(CoralReefWebDriverFactoryImp.class)
public interface CoralReefWebDriverFactory {
    /**
     * Get Web driver instance.
     *
     * @return Web driver instance
     */
    WebDriver getDriverInstance();

    /**
     * initialize web driver
     */
    void initialize();

    /**
     * dispose web driver
     */
    void dispose();
}
