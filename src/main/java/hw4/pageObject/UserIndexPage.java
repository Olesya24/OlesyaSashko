package hw4.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserIndexPage extends AbstractClass {

    private static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "user-name")
    private WebElement userNameText;

    public UserIndexPage(WebDriver driver) {
        super(driver);
    }

    public void openTestSite() {
        driver.get(URL);
    }

    public void login(final String username, final String password) {
        userIcon.click();
        userName.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }

    public String getUserNameText() {
        return userNameText.getText();
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
