package hw5.BasicClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasicClass {

    protected WebDriver driver;
    private static Properties properties;


    static {
        properties = new Properties();
        try{
            InputStream input = new FileInputStream("src/test/resources/hw5/config.properties");
            properties.load(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected final String URL = properties.getProperty("url");
    protected final String USER = properties.getProperty("user");
    protected final String PASSWORD = properties.getProperty("password");

    @BeforeSuite
    public void suiteSetUp(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void setUp() {
        SingletonWebDriver.INSTANCE.createDriver("chrome");
        driver = SingletonWebDriver.INSTANCE.getDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
    }

    // 12. Close browser for ex1
    // 10. Close browser for ex2
    @AfterMethod
    public void tearDown() {
        SingletonWebDriver.INSTANCE.getDriver().quit();
    }
}
