package hw6.voids;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class UserIndexPage extends AbstractClass {
    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(css = ".icons-benefit")
    private List<WebElement> listOfImages;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> textUnderImagesElements;

    @FindBy(id = "frame")
    private WebElement iframe;

    @FindBy(id = "frame-button")
    private WebElement frameButton;

    private WebDriverWait wait;

    public UserIndexPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }

    public void performLogin(String login, String password) {
        userIcon.click();
        name.sendKeys(login);
        this.password.sendKeys(password);
        loginButton.click();
    }
}
