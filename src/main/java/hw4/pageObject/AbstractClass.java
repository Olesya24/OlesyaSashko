package hw4.pageObject;

import hw4.composite.HeaderSection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AbstractClass {
    protected WebDriver driver;
    protected HeaderSection headerSection;
    protected Properties properties;
    protected SummaryCalculate summaryCalculate;

    AbstractClass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        headerSection = new HeaderSection(driver);
        summaryCalculate = new SummaryCalculate();

        properties = new Properties();
        try(InputStream input = new FileInputStream("src/test/resources/hw4/config.properties")) {
            properties.load(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HeaderSection getHeaderSection() {
        return headerSection;
    }

    public SummaryCalculate getSummaryCalculate() {
        return summaryCalculate;
    }
}
