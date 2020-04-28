package hw5.ex1;

import hw5.BasicClasses.AllureScreenshotListener;
import hw5.BasicClasses.BasicClass;
import hw5.steps.UserIndexPageSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

@Listeners({AllureScreenshotListener.class})
public class Ex1Tests extends BasicClass {

    private UserIndexPageSteps userIndexPageSteps;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        userIndexPageSteps = new UserIndexPageSteps();
    }

    @Feature("Test for checking functionality of website")
    @Story("Home page test")
    @Test
    public void firstTests() {

        // 1. Open test site by URL
        userIndexPageSteps.open(URL);

        // 2. Assert Browser Title
        userIndexPageSteps.homePageTitleShouldBe("Home Page");

        // 3. Perform login
        userIndexPageSteps.performLogin(USER, PASSWORD);

        // 4. Assert username is loggined
        userIndexPageSteps.userNameTextShouldBe("ROMAN IOVLEV");

        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        userIndexPageSteps.sizeOfHeaderSectionElentsShouldBe(4);

        userIndexPageSteps.itemsOfHeaderMenuAreDisplayed();
        List<String> expectedHeaderSectionText = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        userIndexPageSteps.headerSectionItemsTextShouldBe(expectedHeaderSectionText);

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        userIndexPageSteps.iconListSizeShouldBe(4);
        userIndexPageSteps.allImagesAreDisplayed();

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        userIndexPageSteps.iconTextsSizeShouldBe(4);
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

        userIndexPageSteps.textUnderIconsShouldBe(expectedTextUnderImages);

        // 8. Assert that there is the iframe with “Frame Button” exists

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        userIndexPageSteps.frameShouldBeDisplayed();
        userIndexPageSteps.switchToFrame();
        userIndexPageSteps.frameButtonShouldBeIntoIframe();

        // 10. Switch to original window back
        userIndexPageSteps.switchToMainWindow();

        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        userIndexPageSteps.leftSectionElementsShouldBeDisplayed();
        List<String> expectedTextOnSideBarElements = Arrays.asList("Home", "Contact form", "Service",
                "Metals & Colors", "Elements packs");
        userIndexPageSteps.leftSidebarElementsTextsShouldBe(expectedTextOnSideBarElements);

        // 12. Close Browser
        // Look at BasicClass.tearDown();
    }
}
