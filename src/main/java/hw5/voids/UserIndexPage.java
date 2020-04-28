package hw5.voids;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class UserIndexPage extends AbstractClass {

    protected WebDriverWait wait;

    protected final int WAIT_TIMEOUT_SECONDS = 10;

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(css = ".icons-benefit")
    private List<WebElement> iconList;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> iconTexts;

    @FindBy(id = "frame")
    private WebElement iframe;

    @FindBy(id = "frame-button")
    private WebElement frameButton;

    public UserIndexPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        PageFactory.initElements(driver, this);
    }

    public void performLogin(String user, String password) {
        userIcon.click();
        name.sendKeys(user);
        this.password.sendKeys(password);
        loginButton.click();
    }


    public boolean allImagesAreDisplayed(){
        boolean isDisplayed = true;
        for(WebElement webElement: this.iconList){
            isDisplayed = (isDisplayed)&&(webElement.isDisplayed());
        }
        return isDisplayed;
    }

    public int getIconListSize(){
        return this.iconList.size();
    }

    public int getIconTextsSize() {
        return this.iconTexts.size();
    }

    public List<String> getIconTexts() {
        List<String> actualIconTexts = new ArrayList<String>();
        for (WebElement element : iconTexts) {
            actualIconTexts.add(element.getText());
        }
        return actualIconTexts;
    }

    public boolean iframeIsDisplayed(){
        return this.iframe.isDisplayed();
    }

    public boolean iframeButtonIsDisplayed(){
        return this.frameButton.isDisplayed();
    }

    public void switchToIframe() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
    }
}
