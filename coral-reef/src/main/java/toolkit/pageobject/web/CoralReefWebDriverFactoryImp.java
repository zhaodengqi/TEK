package toolkit.pageobject.web;

import com.google.inject.Inject;
import contract.CoralReefConfiguration;
import contract.po.CoralReefWebDriverFactory;
import core.exception.CraftsmanRuntimeException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CoralReefWebDriverFactoryImp implements CoralReefWebDriverFactory {
    private WebDriver driver;
    private final CoralReefConfiguration configuration;

    @Inject
    public CoralReefWebDriverFactoryImp(CoralReefConfiguration configuration) {
        this.configuration = configuration;
    }

    public void initialize() {
        if (driver != null) throw new CraftsmanRuntimeException("The WebDriver has been initialized. Do not call 'initialize()' again.");

        //TODO: use different config build different web-driver here.
        String driverDirectory = this.configuration.getOption("driver-directory");
        String localEnvironment = this.configuration.getOption("local-environment");

        String driverPath = String.format("%s/chromedriver", driverDirectory);
        if (localEnvironment.equals("windows")) {
            driverPath = driverPath + ".exe";
        }

        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void dispose() {
        if (driver == null) return;
        driver.quit();
    }

    /**
     * Get Web driver instance.
     *
     * @return Web driver instance
     */
    public WebDriver getDriverInstance() {
        if (this.driver == null)
            throw new NullPointerException("coral-reef: Web-driver is not initialized, please make sure use tags @browser in your feature or scenario");
        return driver;
    }
}
