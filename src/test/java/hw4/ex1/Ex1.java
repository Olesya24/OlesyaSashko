package hw4.ex1;

import hw4.BasicClass;
import hw4.pageObject.UserIndexPage;
import hw4.pageObject.TableWithPages;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Ex1 extends BasicClass {

    private UserIndexPage userIndexPage;
    private TableWithPages tableWithPages;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        userIndexPage = new UserIndexPage(driver);
        tableWithPages = new TableWithPages(driver);
    }

    @Test
    public void exerciseOneTest() {

        // 1. Open test site by URL
        userIndexPage.openTestSite();

        // 2. Assert Browser title
        assertEquals(userIndexPage.getTitle(), "Home Page");

        // 3. Perform login
        userIndexPage.login(properties.getProperty("username"), properties.getProperty("password"));

        // 4. Assert User name in the left-top side of screen that user is loggined
        assertEquals(userIndexPage.getUserNameText(), "ROMAN IOVLEV");

        // 5. Open through the header menu Service -> Table with pages
        userIndexPage.getHeaderSection().getServiceButton().click();
        userIndexPage.getHeaderSection().getTableWithPages().click();

        // 6. Check that default value for “Show entries” dropdown is 5
        assertEquals(tableWithPages.getTableEntriesText(), "5");

        // 7. Select new value for the entries in the dropdown list
        tableWithPages.selectTableEntries("10");

        // 8. Assert that in the table displayed corrected amount of entries
        assertEquals(tableWithPages.getTableWithRowsSize(), 10);

        // 9. Type in “Search” text field
        tableWithPages.typeSearchField(properties.getProperty("search"));

        // 10. Assert the table contains only records with Search field value
        for (WebElement element : tableWithPages.getTableRows()) {
            assertTrue(element.getText().toLowerCase().contains(properties.getProperty("search")));
        }
    }
}
