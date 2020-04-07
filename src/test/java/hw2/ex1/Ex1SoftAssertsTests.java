package hw2.ex1;

import hw2.BasicClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex1SoftAssertsTests extends BasicClass {

    @Test
    public void firstTests() {
        SoftAssert softAssert = new SoftAssert();

        // 1. Open test site by URL
        // in BasicClass

        // 2. Assert Browser Title
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        // 3. Perform login
        performLogin("Roman", "Jdi1234");

        // 4. Assert username is loggined
        softAssert.assertEquals(driver.findElement(By.id("user-name")).getText(), "ROMAN IOVLEV");

        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> header = driver.findElements(By.cssSelector(".m-l8 > li"));
        softAssert.assertEquals(header.size(), 4);

        List<String> expectedHeader = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        List<String> actualHeader = new ArrayList<String>();
        for(WebElement webElement: header){
            actualHeader.add(webElement.getText());
        }

        for(WebElement webElement: header){
            checkWebElementIsDisplayed(webElement, softAssert);
        }

        softAssert.assertEquals(actualHeader, expectedHeader);

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> iconList = driver.findElements(By.className("benefit-icon"));;
        softAssert.assertEquals(iconList.size(), 4);
        for(WebElement webElement : iconList){
            checkWebElementIsDisplayed(webElement, softAssert);
        }

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> iconTexts = driver.findElements(By.className("benefit-txt"));
        softAssert.assertEquals(iconTexts.size(), 4);
        List<String> expectedIconTexts = Arrays.asList(
                "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project", "To be flexible and\n" +
                "customizable", "To be multiplatform", "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…"
        );
        List<String> actualIiconTexts = new ArrayList<String>();
        for(WebElement element : iconTexts){
            actualIiconTexts.add(element.getText());
        }
        softAssert.assertEquals(actualIiconTexts, expectedIconTexts);

        // 8. Assert that there is the iframe with “Frame Button” exist
        WebElement iframe = driver.findElement(By.id("frame"));
        checkWebElementIsDisplayed(iframe, softAssert);

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame(iframe);
        checkWebElementIsDisplayed(driver.findElement(By.id("frame-button")), softAssert);

        // 10. Switch to original window back
        driver.switchTo().defaultContent();

        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> leftSectionMenuElements = driver.findElements(By.cssSelector(".sidebar-menu > li"));
        List<String> expectedLeftSectionMenuElements = Arrays.asList("Home", "Contact form", "Service",
                "Metals & Colors", "Elements packs");
        for(WebElement webElement : leftSectionMenuElements){
            checkWebElementIsDisplayed(webElement, softAssert);
        }
        List<String> actualLeftSectionMenuElements = new ArrayList<String>();
        for(WebElement webElement : leftSectionMenuElements){
            actualLeftSectionMenuElements.add(webElement.getText());
        }

        softAssert.assertEquals(actualLeftSectionMenuElements, expectedLeftSectionMenuElements);


        softAssert.assertAll();


        // 12. Close Browser
        // Look at BasicClass.tearDown();
    }

    public void checkWebElementIsDisplayed(WebElement webElement, SoftAssert softAssert){
        softAssert.assertTrue(webElement.isDisplayed());
    }
}
