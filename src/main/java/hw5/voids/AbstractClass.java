package hw5.voids;

import hw5.composite.AbstractClassComposite;
import hw5.composite.HeaderSection;
import hw5.composite.LeftSection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class AbstractClass extends AbstractClassComposite {
    protected LeftSection leftSectionElement;
    protected HeaderSection headerSectionElement;

    @FindBy(id = "user-name")
    protected WebElement userName;

    protected AbstractClass(WebDriver driver) {
        super(driver);
        leftSectionElement = new LeftSection(driver);
        headerSectionElement = new HeaderSection(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getUserName() {
        return userName;
    }

    public String getUserNameText() {
        return userName.getText();
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public List<String> getActualHeaderSectionElementsNames() {
        return headerSectionElement.getActualHeaderSectionElementNames();
    }

    public int getActualHeaderSectionElementsSize() {
        return headerSectionElement.getHeaderSectionElementSize();
    }

    public boolean HeaderSectionElementsAreDisplayed(){
        return headerSectionElement.HeaderSectionElementsAreDisplayed();
    }

    public boolean LeftSectionElementsAreDisplayed(){
        return leftSectionElement.LeftSectionElementsAreDisplayed();
    }

    public List<String> getLeftSectionElementsText(){
        return leftSectionElement.getLeftSectionElementsText();
    }

    public void openOtherElementsPage() {
        leftSectionElement.openOtherElementsPage();
    }
}
