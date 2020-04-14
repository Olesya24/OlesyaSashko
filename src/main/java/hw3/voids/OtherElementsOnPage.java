package hw3.voids;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class OtherElementsOnPage extends AbstractClass {
    @FindBy(css = ".label-checkbox")
    private List<WebElement> checkboxOptions;

    @FindBy(className = "label-radio")
    private List<WebElement> radioOptions;

    @FindBy(xpath = "//select[@class='uui-form-element']")
    private WebElement dropDown;

    @FindBy(css = ".info-panel-body-log")
    private List<WebElement> listOfLogs;


    public OtherElementsOnPage(WebDriver driver) {
        super(driver);
    }

    private void selectElement(String text, List<WebElement> elements) {
        WebElement element =
                elements
                        .stream()
                        .filter((WebElement el) -> el.getText().equals(text))
                        .findFirst()
                        .get();
        element.click();
    }

    public void selectCheckBox(String text){
        selectElement(text, checkboxOptions);
    }

    public void selectRadio(String text){
        selectElement(text, radioOptions);
    }

    public void selectDropDown(String text) {
        Select dropdown = new Select(dropDown);
        dropdown.selectByVisibleText(text);
    }

    public WebElement getLogElement(String choosedOption, String condition){
        WebElement logElement =
                listOfLogs.stream()
                        .filter((WebElement el) ->
                                el.getText().contains(choosedOption) && el.getText().contains(condition))
                        .findFirst()
                        .get();
        return logElement;
    }

    public boolean logRowsElementIsDisplayed(String choosedOption, String condition){
        return getLogElement(choosedOption, condition).isDisplayed();
    }

}
