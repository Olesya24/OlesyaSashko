package hw5.BasicClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public enum SingletonWebDriver {
    INSTANCE;

    private WebDriver driver;

    public void createDriver(String browserName) {
        if ("CHROME".equalsIgnoreCase(browserName)) {
            driver = new ChromeDriver();
        }
    }

    public WebDriver getDriver(){
        return driver;
    }
}
