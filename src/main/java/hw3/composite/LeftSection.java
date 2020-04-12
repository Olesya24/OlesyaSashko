package hw3.composite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class LeftSection extends AbstractClassComposite {
    @FindBy(css = ".sidebar-menu > li")
    private List<WebElement> leftSectionElements;

    @FindBy(linkText = "Service")
    private WebElement serviceButton;

    @FindBy(linkText = "Different elements")
    private WebElement differentElementsButton;

    public LeftSection(WebDriver driver) {
        super(driver);
    }

    public boolean LeftSectionElementsAreDisplayed(){
        boolean isDisplayed = true;
        for(WebElement webElement: this.leftSectionElements){
            isDisplayed = (isDisplayed)&&(webElement.isDisplayed());
        }
        return isDisplayed;
    }

    public List<String> getLeftSectionElementsText(){
        return leftSectionElements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void openOtherElementsPage(){
        serviceButton.click();
        differentElementsButton.click();
    }
}
