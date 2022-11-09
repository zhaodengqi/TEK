package toolkit;

import com.google.inject.Inject;
import contract.ActionBot;
import contract.CoralReefConfiguration;
import contract.WaitMethod;
import contract.po.CoralReefWebDriverFactory;
import core.exception.CraftsmanRuntimeException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActionBotImp implements ActionBot {
    private CoralReefWebDriverFactory factory;
    private CoralReefConfiguration configuration;

    @Inject
    public ActionBotImp(
            CoralReefWebDriverFactory factory,
            CoralReefConfiguration configuration) {
        this.factory = factory;
        this.configuration = configuration;
    }

    @Override
    public void openUrl(String url) {
        String factUrl = convertUrl(url);
        factory.getDriverInstance().get(factUrl);
    }

    @Override
    public void openOtherUrl(String url) {
        factory.getDriverInstance().get(url);
    }

    private String convertUrl(String url) {
        String key = "sites";
        String subKey = "default-site";

        Pattern pattern = Pattern.compile("\\{.*\\}");
        Matcher matcher = pattern.matcher(url);
        if (matcher.find()) {
            String strMatcher = url.substring(matcher.start(), matcher.end());
            subKey = strMatcher.substring(1, strMatcher.length() - 1);
            String basePath = configuration.getSubOption(key, subKey);
            url = url.replace(strMatcher, basePath);
        } else {
            String basePath = configuration.getSubOption(key, subKey);
            url = String.format("%s/%s", basePath, url);
        }
        return url;
    }

    @Override
    public void click(By locator) {
        WebElement button = waitToGet(locator, WaitMethod.VISIBILITY);
        button.click();
    }

    @Override
    public void clickBlank(int x, int y) throws Exception {
        Actions actions = new Actions(factory.getDriverInstance());
        actions.moveByOffset(x,y).click().build().perform();
    }

    @Override
    public void doubleClick(By locator) {
        WebElement button = waitToGet(locator, WaitMethod.VISIBILITY);
        Actions actions = new Actions(factory.getDriverInstance());
        actions.doubleClick(button).build().perform();
    }

    @Override
    public void rightClick(By locator) {
        WebElement button = waitToGet(locator, WaitMethod.VISIBILITY);
        Actions actions = new Actions(factory.getDriverInstance());
        actions.contextClick(button).build().perform();
    }

    @Override
    public void submit(By locator) {
        WebElement button = waitToGet(locator, WaitMethod.VISIBILITY);
        button.submit();
    }

    @Override
    public void sendKeys(By locator, String text) {
        WebElement input = waitToGet(locator, WaitMethod.VISIBILITY);
        input.sendKeys(text);
    }

    @Override
    public void wait(By locator, WaitMethod waitMethod) {
        //TODO: wait time must come from config file.
        WebDriverWait wait = new WebDriverWait(factory.getDriverInstance(), Duration.ofSeconds(5L));
        switch (waitMethod) {
            case VISIBILITY:
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                break;
            case EXIST:
            case DISPLAY:
            case UN_VISIBILITY:
            case UN_EXIST:
            case UN_DISPLAY:
                throw new CraftsmanRuntimeException("Not Support Now");
            default:
                throw new CraftsmanRuntimeException("Not Support");
        }

    }

    @Override
    public WebElement waitToGet(By locator, WaitMethod waitMethod) {
        wait(locator, waitMethod);
        return factory.getDriverInstance().findElement(locator);
    }

    @Override
    public void waitUrlContains(String url) {
        String factUrl = convertUrl(url);
        WebDriverWait wait = new WebDriverWait(factory.getDriverInstance(), Duration.ofSeconds(5L));
        wait.until(ExpectedConditions.urlContains(factUrl));
    }

    @Override
    public String getText(By locator) {
        WebElement element = waitToGet(locator, WaitMethod.VISIBILITY);
        return element.getText();
    }

    @Override
    public String getAttribute(By locator) {
        WebElement element = waitToGet(locator, WaitMethod.VISIBILITY);
        return element.getAttribute("textContent");

    }

    @Override
    public void clear(By locator) {
        WebElement element = waitToGet(locator, WaitMethod.VISIBILITY);
        element.clear();
    }

    @Override
    public void selectByIndex(By locator, int index) {
        WebElement element = waitToGet(locator, WaitMethod.VISIBILITY);
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    @Override
    public void selectByValue(By locator, String value) {
        WebElement element = waitToGet(locator, WaitMethod.VISIBILITY);
        Select select = new Select(element);
        select.selectByValue(value);
    }

    @Override
    public void selectByVisibleText(By locator, String text) {
        WebElement element = waitToGet(locator, WaitMethod.VISIBILITY);
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    @Override
    public void swipeToElementVisible(By locator) {
        WebDriver driverInstance = factory.getDriverInstance();
        Actions actions = new Actions(driverInstance);
        WebElement element = driverInstance.findElement(locator);
        actions.moveToElement(element).build().perform();

    }

    @Override
    public Boolean isExist(By locator) {
        Boolean isExist = true;
        try {
            waitToGet(locator, WaitMethod.VISIBILITY);
        } catch (Exception exception) {
            isExist = false;
        }
        return isExist;
    }

    @Override
    public void uploadfile(String xpath, String path) throws Exception {
        System.out.println("上传简历xpath:"+xpath);
        System.out.println("上传简历xpath:"+path);
        factory.getDriverInstance().findElement(By.xpath("//a[text()='简历上传']/input")).sendKeys(path);
//

    }

    @Override
    public void inputTextByItems(By locator, String text) {
        Actions actions = new Actions(factory.getDriverInstance());
        List<WebElement> elements = factory.getDriverInstance().findElements(locator);
        for (WebElement element:elements){
            String get_choose_Text = element.getText();
            if (get_choose_Text.equals(text)){
                element.click();

            }
        }
        actions.moveByOffset(0,0).click().build().perform();
    }

    @Override
    public void inputTextByItemsStarsMonth(By locator, String text) {
        List<WebElement> elements = factory.getDriverInstance().findElements(locator);
        for (WebElement element:elements){
            String get_choose_Text = element.getText().substring(0,3);

            if (get_choose_Text.equals(text)){
                element.click();

            }
        }
        new Actions(factory.getDriverInstance()).moveByOffset(0,0).click().build().perform();
    }
}
