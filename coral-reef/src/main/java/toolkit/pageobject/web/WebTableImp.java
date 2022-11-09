package toolkit.pageobject.web;

import com.google.inject.Inject;
import contract.ActionBot;
import contract.po.component.LocatorType;
import contract.po.component.WebTable;
import org.openqa.selenium.By;

public class WebTableImp extends BaseWebComponent implements WebTable {
    @Override
    public WebTable setLocator(LocatorType type, String value) {
        this.locator = buildLocator(type, value);
        this.basePath = value;
        return this;
    }

    private final ActionBot actionBot;

    @Inject
    public WebTableImp(
            ActionBot actionBot
    ) {
        this.actionBot = actionBot;
    }

    @Override
    public String getCellText(int row, int column) {
        return actionBot.getText(buildCellByObject(row, column));
    }

    @Override
    public void clickLinkInCell(int row, int column) {
        By by = buildCellByObject(row, column, "a");
        actionBot.click(by);
    }

    @Override
    public Boolean isExist(int row, int column) {
        return actionBot.isExist(buildCellByObject(row, column));
    }

    private By buildCellByObject(int row, int column) {
        String headerCell = String.format("%s//tr[%s]/th[%s]", basePath, row + 1, column);
        String dataCell = String.format("%s//tr[%s]/td[%s]", basePath, row + 1, column);
        return By.xpath(String.format("(%s)|(%s)", headerCell, dataCell));
    }

    private By buildCellByObject(int row, int column, String subPath) {
        String headerCell = String.format("%s//tr[%s]/th[%s]//%s", basePath, row + 1, column, subPath);
        String dataCell = String.format("%s//tr[%s]/td[%s]//%s", basePath, row + 1, column, subPath);
        return By.xpath(String.format("(%s)|(%s)", headerCell, dataCell));
    }
}
