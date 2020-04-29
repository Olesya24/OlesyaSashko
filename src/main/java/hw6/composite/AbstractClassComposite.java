package hw6.composite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractClassComposite {
    protected WebDriver driver;

    protected AbstractClassComposite(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
