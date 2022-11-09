package contract;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface ActionBot {
    void openUrl(String url);

    void openOtherUrl(String url);

    void click(By locator);
    void clickBlank(int x,int y)throws Exception;

    void doubleClick(By locator);

    void rightClick(By locator);

    void submit(By locator);

    void sendKeys(By locator, String text);

    void wait(By locator, WaitMethod waitMethod);

    WebElement waitToGet(By locator, WaitMethod waitMethod);

    void waitUrlContains(String url);

    String getText(By locator);

    String getAttribute(By locator);

    void clear(By locator);

    void selectByIndex(By locator, int index);

    void selectByValue(By locator, String value);

    void selectByVisibleText(By locator, String text);

    void swipeToElementVisible(By locator);

    Boolean isExist(By locator);

    void uploadfile(String xpath,String path)throws Exception;

    void inputTextByItems(By locator, String text);

    void inputTextByItemsStarsMonth(By locator, String text);
}
