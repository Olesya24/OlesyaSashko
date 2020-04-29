package hw6.composite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LeftSection extends AbstractClassComposite {
    @FindBy(linkText = "Service")
    private WebElement serviceButton;

    @FindBy(xpath = "//ul[@class='sub']/li/a")
    private List<WebElement> subSideBarElements;


    public LeftSection(WebDriver driver) {
        super(driver);
    }

    public void clickServiceButton(){
        serviceButton.click();
    }

    public void clickButtonOfLeftSectionMenu(String text){
        for (int i = 0; i < subSideBarElements.size(); ++i){
            if (text.equals(subSideBarElements.get(i).getText())){
                subSideBarElements.get(i).click();
                break;
            }
        }
    }
}
