package hw6.voids;

import hw6.composite.AbstractClassComposite;
import hw6.composite.LeftSection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractClass extends AbstractClassComposite {
    protected LeftSection leftSidebarSectionElements;

    @FindBy(id = "user-name")
    protected WebElement userName;

    protected AbstractClass(WebDriver driver) {
        super(driver);
        leftSidebarSectionElements = new LeftSection(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getUserName() {
        return userName;
    }

    public String getUserNameText() {
        return userName.getText();
    }

    public String getBrowserTitle() {
        return driver.getTitle();
    }

    public void clickServiceButton() {
        leftSidebarSectionElements.clickServiceButton();
    }

    public void clickDifferentElementsButton() {
        leftSidebarSectionElements.clickButtonOfLeftSectionMenu("Different elements");
    }

    public void clickUserTableButton(){
        leftSidebarSectionElements.clickButtonOfLeftSectionMenu("User Table");
    }
}
