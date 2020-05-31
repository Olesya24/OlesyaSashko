package hw6.hooks;

import hw6.SingletonDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CucumberHooks {
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        SingletonDriver.INSTANCE.createDriver("chrome");
    }

    @After
    public void tearDown(){
        SingletonDriver.INSTANCE.getDriver().close();
    }
}
