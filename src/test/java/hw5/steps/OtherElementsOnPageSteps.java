package hw5.steps;

import hw5.BasicClasses.AbstractBasicClass;
import io.qameta.allure.Step;

import static org.testng.Assert.assertTrue;

public class OtherElementsOnPageSteps extends AbstractBasicClass {
    public OtherElementsOnPageSteps() {
        super();
    }

    @Step("I select checkbox '{0}'")
    public void selectCheckbox(String value){
        otherElementsOnPage.selectCheckBox(value);
    }

    @Step("I select radio '{0}'")
    public void selectRadio(String value){
        otherElementsOnPage.selectRadio(value);
    }

    @Step("I select dropdown '{0}'")
    public void selectColor(String value){
        otherElementsOnPage.selectDropDown(value);
    }

    @Step("Individual Log Row And Correct Status")
    public void individualLogRowAndRightStatusShouldBe(String option, String condition){
        assertTrue(otherElementsOnPage.logRowsElementIsDisplayed(option, condition));
    }
}
