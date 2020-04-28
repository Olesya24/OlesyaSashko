package hw4.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TableWithPages extends AbstractClass {

    @FindBy(name = "table-with-pages_length")
    private WebElement tableEntries;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement search;

    @FindBy(css = "tbody > tr")
    private List<WebElement> tableRows;

    public TableWithPages(WebDriver driver) {
        super(driver);
    }


    public String getTableEntriesText() {
        Select defaultValue = new Select(tableEntries);
        return defaultValue.getFirstSelectedOption().getText();
    }

    public void selectTableEntries(String entry) {
        Select dropdown = new Select(tableEntries);
        dropdown.selectByVisibleText(entry);
    }

    public void typeSearchField(String search) {
        this.search.sendKeys(search);
    }

    public List<WebElement> getTableRows() {
        return tableRows;
    }

    public int getTableWithRowsSize(){
        return tableRows.size();
    }
}
