package hw2.ex2;

import hw2.BasicClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Ex2AssertsOnPageTests extends BasicClass {
    @Test
    public void secondTests() {
        // 1. Open test site by URL
        // in BasicClass

        // 2. Assert Browser Title
        assertEquals(driver.getTitle(), "Home Page");

        // 3. Perform login
        performLogin("Roman", "Jdi1234");

        // 4. Assert User name in the left-top side of screen that user is loggined
        assertEquals(driver.findElement(By.id("user-name")).getText(), "ROMAN IOVLEV");

        // 5. Open through the header menu Service -> Different Elements Page
        driver.findElement(By.linkText("Service")).click();
        driver.findElement(By.linkText("Different elements")).click();

        // 6. Select checkboxes
        WebElement water = driver.findElement(By.xpath("//label[normalize-space() = 'Water']"));
                water.click();
        assertTrue(water.isEnabled());
        WebElement wind = driver.findElement(By.xpath("//label[normalize-space() = 'Wind']"));
        wind.click();
        assertTrue(wind.isEnabled());

        // 7. Select radio
        WebElement selen = driver.findElement(By.xpath("//label[normalize-space() = 'Selen']"));
        selen.click();
        assertTrue(selen.isEnabled());

        // 8. Select in dropdown
        WebElement dropDownMenu = driver.findElement(By.cssSelector(".colors select"));
        Select element = new Select(dropDownMenu);
        element.selectByVisibleText("Yellow");
        assertEquals(element.getFirstSelectedOption().getText(), "Yellow");

        // 9. Assert that
        // 1) for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        WebElement waterLog = driver.findElement(By.xpath("//li[contains(text(),'Water') and contains(text(),'true')]"));
        assertEquals(waterLog.getText().substring(9),"Water: condition changed to true" );
        assertTrue(waterLog.isDisplayed());

        WebElement windLog = driver.findElement(By.xpath("//li[contains(text(),'Wind') and contains(text(),'true')]"));
        assertEquals(windLog.getText().substring(9),"Wind: condition changed to true" );
        assertTrue(windLog.isDisplayed());

        // 2) for radio button there is a log row and value is corresponded to the status of radio button
        WebElement selenLog = driver.findElement(By.xpath("//li[contains(text(),'metal') and contains(text(),'Selen')]"));
        assertEquals(selenLog.getText().substring(9),"metal: value changed to Selen" );
        assertTrue(selenLog.isDisplayed());

        // 3) for dropdown there is a log row and value is corresponded to the selected value
        WebElement colorYellowLog = driver.findElement(By.xpath("//li[contains(text(),'Colors') and contains(text(),'Yellow')]"));
        assertEquals(colorYellowLog.getText().substring(9),"Colors: value changed to Yellow" );
        assertTrue(colorYellowLog.isDisplayed());
    }
}
