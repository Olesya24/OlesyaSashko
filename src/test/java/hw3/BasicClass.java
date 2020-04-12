package hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasicClass {

    //private final String URL = "https://jdi-testing.github.io/jdi-light/index.html";
    protected WebDriver driver;
    protected Properties properties;


    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        properties = new Properties();
        try{
            InputStream input = new FileInputStream("src/test/resources/hw3/config.properties");
            properties.load(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        openTestSite(properties.getProperty("url"));



    }

    // 1. Open test site by URL
    public void openTestSite(String URL){
        driver.get(properties.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7000, TimeUnit.MILLISECONDS);
    }

    // 12. Close browser for ex1
    // 10. Close browser for ex2
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
