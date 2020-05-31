package hw6.steps;

import io.cucumber.java.en.When;

public class WhenSteps extends BasicStep {
    @When("I click on Service button in Header")
    public  void clickServiceButton(){
        userIndexPage.clickServiceButton();
    }

    @When("I click Different elements button")
    public void clickDifferentElementsButton(){
        userIndexPage.clickDifferentElementsButton();
    }

    @When("I select checkbox {string}")
    public void selectCheckbox(String string) {
        otherElementsOnPage.selectCheckBoxElement(string);
    }

    @When("I select radio {string}")
    public void selectRadio(String string) {
        otherElementsOnPage.selectRadioElement(string);
    }

    @When("I select in dropdown {string}")
    public void selectValueInDropdown(String string) {
        otherElementsOnPage.selectDropDownElement(string);
    }

    @When("I click on User Table button in Service dropdown")
    public void clickUserTableButton(){
        userIndexPage.clickUserTableButton();
    }

    @When("I select 'vip' checkbox for {string}")
    public void selectVipCheckbox(String name){
        userTablePage.clickVipCheckboxForUsername(name);
    }
}
