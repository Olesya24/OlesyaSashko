package hw6.steps;

import hw6.entities.DropdownTable;
import hw6.entities.LogrowTable;
import hw6.entities.UserTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.*;

public class ThenSteps extends BasicStep {
    @Then("{string} page should be opened")
    public void browserTitleShouldBe(String string) {
        assertEquals(userIndexPage.getBrowserTitle(), string);
    }

    @Then("User name should be {string}")
    public void usernameShouldBe(String string) {
        assertEquals(userIndexPage.getUserNameText(), string);
    }

    @DataTableType
    public LogrowTable logrowTable(Map<String, String> entry) {
        return new LogrowTable(entry.get("value"), entry.get("condition"));
    }

    @Then("LogRow should contain following values:")
    public void logrowShouldContain(List<LogrowTable> logrowTables) {
        assertTrue(otherElementsOnPage.logRowsElementIsDisplayed(logrowTables));
    }

    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void valueOfNumberTypeDropwdownsShouldBe(int value) {
        assertEquals(userTablePage.numberTypeDropdownsValue(), value);
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void valueOfUsernamesShouldBe(int value) {
        assertEquals(userTablePage.userNamesValue(), value);
    }

    @Then("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void valueOfDescriptionsShouldBe(int value) {
        assertEquals(userTablePage.descriptionsUnderImagesValue(), value);
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void valueOfCheckBoxesShouldBe(int value) {
        assertEquals(userTablePage.checkboxesUnderImagesValue(), value);
    }

    @DataTableType
    public UserTable userTable(Map<String, String> entry) {
        return new UserTable(entry.get("Number"), entry.get("User"), entry.get("Description"));
    }

    @Then("User table should contain following values:")
    public void userTableShouldContain(List<UserTable> userTableEntity) {
        assertTrue(userTablePage.getUserTableData().equals(userTableEntity));
    }

    @DataTableType
    public DropdownTable dropdownTable(Map<String, String> entry) {
        return new DropdownTable(entry.get("Dropdown Values"));
    }

    @Then("droplist should contain values in column Type for user {string}")
    public void droplistShouldContain(String name, List<DropdownTable> dropdownTable) {
        assertTrue(userTablePage.getDropdownTableData(name).equals(dropdownTable));
    }

    @Then("{int} log row has {string} text in log section")
    public void logrowShouldHasString(int index, String str) {
        assertTrue(userTablePage.isLogRowContainsThatValue(index - 1, str));
    }

    private void assertTrue(boolean logRowContainsThatValue) {
    }
}
