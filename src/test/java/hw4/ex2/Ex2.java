package hw4.ex2;

import hw4.BasicClass;
import hw4.builder.MetalAndColorsBuilder;
import hw4.pageObject.UserIndexPage;
import hw4.pageObject.MetalAndColorsPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Ex2 extends BasicClass {

    private UserIndexPage userIndexPage;
    private MetalAndColorsPage metalAndColorsPage;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        userIndexPage = new UserIndexPage(driver);
        metalAndColorsPage = new MetalAndColorsPage(driver);
    }

    @Test(dataProviderClass = MetalAndColorDataProvider.class, dataProvider = "testData")
    public void exerciseTwoTest(MetalAndColorsBuilder metalAndColorsBuilder) {

        // 1. Open test site by URL
        userIndexPage.openTestSite();

        // 2. Perform login
        userIndexPage.login(properties.getProperty("username"), properties.getProperty("password"));
        assertEquals(userIndexPage.getUserNameText(), "ROMAN IOVLEV");

        // 3. Click on the link on the Header section
        userIndexPage.getHeaderSection().getMetalAndColorPage().click();

        // 4. Fill form on the page
        if (metalAndColorsBuilder.getSummary() != null) {
            metalAndColorsPage.selectWebElement(metalAndColorsPage
                    .getSummaryButtons(), metalAndColorsBuilder.getSummary());
        }

        if (metalAndColorsBuilder.getElements() != null) {
            metalAndColorsPage.selectWebElement(metalAndColorsPage
                    .getElementsCheckboxes(), metalAndColorsBuilder.getElements(
            ));
        }

        if (metalAndColorsBuilder.getColors() != null) {
            metalAndColorsPage.getColorsDropdown().click();
            metalAndColorsPage.selectWebElement(metalAndColorsPage
                    .getColorAndMetalOptions(), metalAndColorsBuilder.getColors());
        }

        if (metalAndColorsBuilder.getMetals() != null) {
            metalAndColorsPage.getMetalDropdown().click();
            metalAndColorsPage.selectWebElement(metalAndColorsPage
                    .getColorAndMetalOptions(), metalAndColorsBuilder.getMetals());
        }


        if (metalAndColorsBuilder.getVegetables() != null) {
            metalAndColorsPage.getVegetablesDropdown().click();
            metalAndColorsPage.uncheckVegetables();
            metalAndColorsPage.selectWebElement(metalAndColorsPage
                    .getVegetablesCheckboxes(), metalAndColorsBuilder.getVegetables());

        }

        // 5. Click “Submit” button
        metalAndColorsPage.clickSubmitButton();

        // 6. Check Results block output on the right-side
        for (WebElement result : metalAndColorsPage.getResults()) {

            if (metalAndColorsBuilder.getSummary() != null && result.getText().contains("Summary")) {
                assertTrue(result.getText().contains(metalAndColorsPage.getSummaryCalculate().summaryCalc(metalAndColorsBuilder.getSummary())));
            }

            if (metalAndColorsBuilder.getElements() != null && result.getText().contains("Elements")) {
                assertTrue(result.getText().contains(String.join(", ", metalAndColorsBuilder.getElements())));
            }

            if (metalAndColorsBuilder.getColors() != null && result.getText().contains("Colors")) {
                assertTrue(result.getText().contains(String.join(", ", metalAndColorsBuilder.getColors())));
            }

            if (metalAndColorsBuilder.getMetals() != null && result.getText().contains("Metals")) {
                assertTrue(result.getText().contains(String.join(",", metalAndColorsBuilder.getMetals())));
            }

            if (metalAndColorsBuilder.getVegetables() != null && result.getText().contains("Vegetables")) {
                assertTrue(result.getText().contains(String.join(", ", metalAndColorsBuilder.getVegetables())));
            }
        }
    }
}
