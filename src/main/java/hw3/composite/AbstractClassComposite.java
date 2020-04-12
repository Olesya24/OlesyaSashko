package hw3.composite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractClassComposite {
    protected WebDriver driver;

    public AbstractClassComposite(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
