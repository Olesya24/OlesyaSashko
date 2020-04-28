package hw5.ex2;

import hw5.BasicClasses.AllureScreenshotListener;
import hw5.BasicClasses.BasicClass;
import hw5.steps.UserIndexPageSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureScreenshotListener.class})
public class WrongEx1Tests extends BasicClass {

    @Feature("Test for checking functionality of website")
    @Story("Home page wrong test")
    @Test
    public void checkWebElementsOnPage() {

        UserIndexPageSteps userIndexPageSteps = new UserIndexPageSteps();
        // 1. Open site by URL
        userIndexPageSteps.open(URL);

        // 2. Assert Browser title
        userIndexPageSteps.homePageTitleShouldBe("Wrong Home Page");

        // 3. Perform login
        userIndexPageSteps.performLogin(USER, PASSWORD);

        // 4. Assert username is loggined
        userIndexPageSteps.userNameTextShouldBe("ROMAN KHODAKOVSKY");


    }
}
