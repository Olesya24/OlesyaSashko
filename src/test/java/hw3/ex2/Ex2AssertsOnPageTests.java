package hw3.ex2;

import hw3.BasicClass;
import hw3.voids.OtherElementsOnPage;
import hw3.voids.UserIndexPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Ex2AssertsOnPageTests extends BasicClass {
    @Test
    public void secondTests() {
        UserIndexPage userIndexPage = new UserIndexPage(driver);
        OtherElementsOnPage otherElementsOnPage = new OtherElementsOnPage(driver);
        // 1. Open test site by URL


        // 2. Assert Browser Title
        assertEquals(userIndexPage.getTitle(), "Home Page");

        // 3. Perform login
        userIndexPage.performLogin(USER, PASSWORD);

        // 4. Assert User name in the left-top side of screen that user is loggined
        assertEquals(userIndexPage.getUserNameText(), "ROMAN IOVLEV");

        // 5. Open through the header menu Service -> Different Elements Page
        userIndexPage.openOtherElementsPage();

        // 6. Select checkboxes
        otherElementsOnPage.selectCheckBox("Water");
        otherElementsOnPage.selectCheckBox("Wind");

        // 7. Select radio
        otherElementsOnPage.selectRadio("Selen");

        // 8. Select in dropdown
        otherElementsOnPage.selectDropDown("Yellow");

        // 9. Assert that
        // 9.1. for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        assertTrue(otherElementsOnPage.logRowsElementIsDisplayed("Water", "true"));
        assertTrue(otherElementsOnPage.logRowsElementIsDisplayed("Wind", "true"));


        // 9.2. for radio button there is a log row and value is corresponded to the status of radio button
        assertTrue(otherElementsOnPage.logRowsElementIsDisplayed("metal", "Selen"));
        // 9.3. for dropdown there is a log row and value is corresponded to the selected value
        assertTrue(otherElementsOnPage.logRowsElementIsDisplayed("Colors", "Yellow"));
    }

}
