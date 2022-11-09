package contract.po.component;

public interface WebTable {
    WebTable  setLocator(LocatorType type, String value);
    String getCellText(int row, int column) ;
    void clickLinkInCell(int row, int column);
    Boolean isExist(int row, int column) ;
}
