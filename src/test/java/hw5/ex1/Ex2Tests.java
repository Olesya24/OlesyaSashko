package hw5.ex1;

import hw5.BasicClasses.AllureScreenshotListener;
import hw5.BasicClasses.BasicClass;
import hw5.steps.OtherElementsOnPageSteps;
import hw5.steps.UserIndexPageSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners({AllureScreenshotListener.class})
public class Ex2Tests extends BasicClass {

    private OtherElementsOnPageSteps otherElementsOnPageSteps;
    private UserIndexPageSteps userIndexPageSteps;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        otherElementsOnPageSteps = new OtherElementsOnPageSteps();
        userIndexPageSteps = new UserIndexPageSteps();
    }

    @Feature("Test for checking functionality of website")
    @Story("Home page test")
    @Test
    public void secondTests() {

        // 1. Open test site by URL
        userIndexPageSteps.open(URL);

        // 2. Assert Browser Title
        userIndexPageSteps.homePageTitleShouldBe("Home Page");

        // 3. Perform login
        userIndexPageSteps.performLogin(USER, PASSWORD);

        // 4. Assert User name in the left-top side of screen that user is loggined
        userIndexPageSteps.userNameTextShouldBe("ROMAN IOVLEV");

        // 5. Open through the header menu Service -> Different Elements Page
        userIndexPageSteps.openOtherElementsPage();

        // 6. Select checkboxes
        otherElementsOnPageSteps.selectCheckbox("Water");
        otherElementsOnPageSteps.selectCheckbox("Wind");

        // 7. Select radio
        otherElementsOnPageSteps.selectRadio("Selen");

        // 8. Select in dropdown
        otherElementsOnPageSteps.selectColor("Yellow");

        // 9. Assert that
        // 9.1. for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        otherElementsOnPageSteps.individualLogRowAndRightStatusShouldBe("Water", "true");
        otherElementsOnPageSteps.individualLogRowAndRightStatusShouldBe("Wind", "true");


        // 9.2. for radio button there is a log row and value is corresponded to the status of radio button
        otherElementsOnPageSteps.individualLogRowAndRightStatusShouldBe("metal", "Selen");
        // 9.3. for dropdown there is a log row and value is corresponded to the selected value
        otherElementsOnPageSteps.individualLogRowAndRightStatusShouldBe("Colors", "Yellow");
    }

}
