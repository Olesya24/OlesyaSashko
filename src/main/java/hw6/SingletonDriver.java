package hw6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public enum SingletonDriver {
    INSTANCE;

    private WebDriver driver;

    public void createDriver(String browserName) {
        if ("CHROME".equalsIgnoreCase(browserName)) {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
            driver.manage().window().maximize();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}