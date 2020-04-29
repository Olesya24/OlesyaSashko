package hw5.composite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class HeaderSection extends AbstractClassComposite {
    @FindBy(css = ".m-l8 > li")
    private List<WebElement> headerSectionElements;

    public HeaderSection(WebDriver driver) {
        super(driver);
    }

    public int getHeaderSectionElementSize(){
        return this.headerSectionElements.size();
    }


    public boolean HeaderSectionElementsAreDisplayed(){
        boolean isDisplayed = true;
        for(WebElement webElement: this.headerSectionElements){
            isDisplayed = (isDisplayed)&&(webElement.isDisplayed());
        }
        return isDisplayed;
    }

    public List<String> getActualHeaderSectionElementNames() {
        return headerSectionElements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
