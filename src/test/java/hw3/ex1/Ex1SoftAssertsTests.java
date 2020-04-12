package hw3.ex1;

import hw3.BasicClass;
import hw3.voids.UserIndexPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;

public class Ex1SoftAssertsTests extends BasicClass {

    @Test
    public void firstTests() {
        SoftAssert softAssert = new SoftAssert();
        UserIndexPage userIndexPage = new UserIndexPage(driver);
        // 1. Open test site by URL
        // in BasicClass

        // 2. Assert Browser Title
        softAssert.assertEquals(userIndexPage.getTitle(), "Home Page");

        // 3. Perform login
        userIndexPage.performLogin(properties.getProperty("user"), properties.getProperty("password") );

        // 4. Assert username is loggined
        softAssert.assertEquals(userIndexPage.getUserNameText(), "ROMAN IOVLEV");

        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        softAssert.assertEquals(userIndexPage.getActualHeaderSectionElementsSize(), 4);

        softAssert.assertTrue(userIndexPage.HeaderSectionElementsAreDisplayed());
        List<String> expectedHeaderSectionText = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        softAssert.assertEquals(userIndexPage.getActualHeaderSectionElementsNames(), expectedHeaderSectionText);

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        softAssert.assertEquals(userIndexPage.getIconListSize(), 4);
        userIndexPage.allImagesAreDisplayed();

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        softAssert.assertEquals(userIndexPage.getIconTextsSize(), 4);
        List<String> expectedTextUnderImages = Arrays.asList("To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM project"
                ,  "To be flexible and\n" +
                        "customizable"
                , "To be multiplatform"
                , "Already have good base\n" +
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more…");

        softAssert.assertEquals(userIndexPage.getIconTexts(), expectedTextUnderImages);

        // 8. Assert that there is the iframe with “Frame Button” exists

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        softAssert.assertTrue(userIndexPage.iframeIsDisplayed());
        userIndexPage.switchToIframe();
        softAssert.assertTrue(userIndexPage.iframeButtonIsDisplayed());

        // 10. Switch to original window back
        driver.switchTo().defaultContent();

        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        softAssert.assertTrue(userIndexPage.LeftSectionElementsAreDisplayed());
        List<String> expectedTextOnSideBarElements = Arrays.asList("Home", "Contact form", "Service",
                "Metals & Colors", "Elements packs");
        softAssert.assertEquals(userIndexPage.getLeftSectionElementsText(), expectedTextOnSideBarElements);

        softAssert.assertAll();


        // 12. Close Browser
        // Look at BasicClass.tearDown();
    }
}
