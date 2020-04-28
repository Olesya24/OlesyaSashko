package hw4.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MetalAndColorsPage extends AbstractClass {

    @FindBy(css = "p.radio > label")
    private List<WebElement> summaryButtons;

    @FindBy(css = "p.checkbox > label")
    private List<WebElement> elementsCheckboxes;

    @FindBy(css = "button[title='Colors']")
    private WebElement colorsDropdown;

    @FindBy(xpath = "//button[@title='Metals']//span[2]")
    private WebElement metalDropdown;

    @FindBy(xpath = "//ul[@class='dropdown-menu inner selectpicker']//li")
    private List<WebElement> colorAndMetalOptions;

    @FindBy(xpath = "//button[@class='btn btn-default dropdown-toggle']")
    private WebElement vegetablesDropdown;

    @FindBy(css = ".dropdown-menu > li > a > label")
    private List<WebElement> vegetablesCheckboxes;

    @FindBy(css = "#submit-button")
    private WebElement submitButton;

    @FindBy(xpath = "//ul[@class='panel-body-list results']//li")
    private List<WebElement> results;

    //private SummaryCalculate summaryCalculate;

    public MetalAndColorsPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getSummaryButtons() {
        return summaryButtons;
    }

    public List<WebElement> getElementsCheckboxes() {
        return elementsCheckboxes;
    }

    public List<WebElement> getColorAndMetalOptions() {
        return colorAndMetalOptions;
    }

    public List<WebElement> getVegetablesCheckboxes() {
        return vegetablesCheckboxes;
    }

    public WebElement getColorsDropdown() {
        return colorsDropdown;
    }

    public WebElement getMetalDropdown() {
        return metalDropdown;
    }

    public WebElement getVegetablesDropdown() {
        return vegetablesDropdown;
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public List<WebElement> getResults() {
        return results;
    }

    public void selectWebElement(List<WebElement> webElements, List<String> webElementName) {
        for (WebElement element : webElements) {
            if (webElementName.contains(element.getText())) {
                element.click();
            }
        }
    }

    public void uncheckVegetables() {
        for (WebElement element : vegetablesCheckboxes) {
            if (element.getText().contains(properties.getProperty("default"))) {
                element.click();
            }
        }
    }
}
