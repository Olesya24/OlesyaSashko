package hw6.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"classpath:hw6/features"},
        glue = {"hw6"}
)
public class CucumberRunner extends AbstractTestNGCucumberTests {
}
