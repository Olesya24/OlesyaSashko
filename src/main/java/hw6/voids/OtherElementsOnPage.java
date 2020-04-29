package hw6.voids;

import hw6.entities.LogrowTable;
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

        @FindBy(xpath = "//ul[@class='panel-body-list logs']")
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

        public void selectCheckBoxElement(String text){
            selectElement(text, checkboxOptions);
        }

        public void selectRadioElement(String text){
            selectElement(text, radioOptions);
        }

        public void selectDropDownElement(String text) {
            Select dropdown = new Select(dropDown);
            dropdown.selectByVisibleText(text);
        }

        public WebElement getLogRowsElements(String choosedOption, String condition){
            WebElement logElement =
                    listOfLogs.stream()
                            .filter((WebElement el) ->
                                    el.getText().contains(choosedOption) && el.getText().contains(condition))
                            .findFirst()
                            .get();
            return logElement;
        }

        public boolean logRowsElementIsDisplayed(List<LogrowTable> logrowTables){
            boolean elementIsDisplayed = true;
            for(int i = 0; i < logrowTables.size(); i++) {
                elementIsDisplayed &= getLogRowsElements(logrowTables.get(i).getLogrowValue(),
                        logrowTables.get(i).getLogrowCondition()).isDisplayed();
            }
            return elementIsDisplayed;
        }
}
