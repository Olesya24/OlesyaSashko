package hw6.steps;

import hw6.DataProperties;
import hw6.SingletonDriver;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class GivenSteps extends BasicStep {
        @Given("I open JDI GitHub site")
        public void openPageByURL() {
            WebDriver driver = SingletonDriver.INSTANCE.getDriver();
            String data = DataProperties.getDataProperty().getProperty("URL");
            driver.get(data);
        }

        @Given("I login as user Roman Iovlev")
        public void performLoginByLoginAndPassword() {
            userIndexPage.performLogin(DataProperties.getDataProperty().getProperty("user"),
                    DataProperties.getDataProperty().getProperty("password"));
        }
}
