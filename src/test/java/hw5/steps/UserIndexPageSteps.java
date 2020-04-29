package hw5.steps;

import hw5.BasicClasses.AbstractBasicClass;
import io.qameta.allure.Step;

import java.util.List;

import static org.testng.Assert.*;

public class UserIndexPageSteps extends AbstractBasicClass {
    public UserIndexPageSteps() {
        super();
    }

    @Step("I open '{0}' URL")
    public void open(String url){
        driver.get(url);
    }

    @Step("Page title should be '{0}'")
    public void homePageTitleShouldBe(String expectedPageTitle) {
        assertEquals(driver.getTitle(), expectedPageTitle);
    }

    @Step("I log in as '{0}")
    public void performLogin(String user, String password){
        userIndexPage.performLogin(user, password);
    }

    @Step("Username should be '{0}'")
    public void userNameTextShouldBe(String name){
        assertEquals(userIndexPage.getUserNameText(), name);
    }

    @Step("Texts on the header section should be  '{0}' value")
    public void sizeOfHeaderSectionElentsShouldBe(int value){
        assertEquals(userIndexPage.getActualHeaderSectionElementsSize(), value);
    }

    @Step("Header sections items should be displayed")
    public void itemsOfHeaderMenuAreDisplayed(){
        assertTrue(userIndexPage.HeaderSectionElementsAreDisplayed());
    }

    @Step("Items text on the header section should be '{0}'")
    public void headerSectionItemsTextShouldBe(List<String> expected){
        assertEquals(userIndexPage.getActualHeaderSectionElementsNames(), expected);
    }

    @Step("'{0}' icon on the home page should be displayed")
    public void iconListSizeShouldBe(int expected){
        assertEquals(userIndexPage.getIconListSize(), expected);
    }

    @Step("All images are displayed")
    public void allImagesAreDisplayed(){
        userIndexPage.allImagesAreDisplayed();
    }

    @Step("'{0}' value of texts on the Index Page should be under icons")
    public void iconTextsSizeShouldBe(int expected){
        assertEquals(userIndexPage.getIconTextsSize(), expected);
    }

    @Step("'{0}' text should be under icons")
    public void textUnderIconsShouldBe(List<String> expected){
        assertEquals(userIndexPage.getIconTexts(), expected);
    }

    @Step("frame should be displayed on the page")
    public void frameShouldBeDisplayed(){
        assertTrue(userIndexPage.iframeIsDisplayed());
    }

    @Step("I switch to the frame")
    public void switchToFrame(){
        userIndexPage.switchToIframe();
    }

    @Step("Frame button should be into iframe")
    public void frameButtonShouldBeIntoIframe(){
        assertTrue(userIndexPage.iframeButtonIsDisplayed());
    }

    @Step("I switch to main window back")
    public void switchToMainWindow(){
        driver.switchTo().defaultContent();
    }

    @Step("Left Section should be displayed")
    public void leftSectionElementsShouldBeDisplayed(){
        assertTrue(userIndexPage.LeftSectionElementsAreDisplayed());
    }

    @Step("Left Section texts should be '{0}'")
    public void leftSidebarElementsTextsShouldBe(List<String> expected){
        assertEquals(userIndexPage.getLeftSectionElementsText(), expected);
    }

    @Step("I go to Other Elements Page")
    public void openOtherElementsPage(){
        userIndexPage.openOtherElementsPage();
    }
}
