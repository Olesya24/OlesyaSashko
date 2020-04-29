package hw5.BasicClasses;

import hw5.voids.OtherElementsOnPage;
import hw5.voids.UserIndexPage;
import org.openqa.selenium.WebDriver;

public abstract class AbstractBasicClass {
    protected WebDriver driver;

    protected UserIndexPage userIndexPage;
    protected OtherElementsOnPage otherElementsOnPage;

    public AbstractBasicClass() {
        driver = SingletonWebDriver.INSTANCE.getDriver();
        userIndexPage = new UserIndexPage(driver);
        otherElementsOnPage = new OtherElementsOnPage(driver);
    }
}
