package hw4.composite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HeaderSection extends AbstractClassComposite {

    protected WebDriver driver;

    @FindBy(css = ".m-l8 > li")
    private List<WebElement> headerItems;

    @FindBy(className = "dropdown-toggle")
    private WebElement serviceButton;

    @FindBy(linkText = "TABLE WITH PAGES")
    private WebElement tableWithPages;

    @FindBy(linkText = "METALS & COLORS")
    private WebElement metalAndColorPage;

    public HeaderSection(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getHeaderItems() {
        return this.headerItems;
    }

    public WebElement getServiceButton() {
        return this.serviceButton;
    }

    public WebElement getTableWithPages() {
        return this.tableWithPages;
    }

    public WebElement getMetalAndColorPage() {
        return metalAndColorPage;
    }
}
