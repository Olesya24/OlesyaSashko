package hw1.trigonometryFunc;

import hw1.BasicClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SinusTest extends BasicClass {

    @DataProvider
    public Object[][] dataProviderArgs(){
        return new Object[][] {
                {0.0, 0.0000},
                {90.0, 1.0000},
                {270.0, -1.0000}
        };
    }

    @Test(dataProvider = "dataProviderArgs")
    public void sinMethodTest(double a, double expectedResult){
        assertEquals(calculator.sin(Math.toRadians(a)), expectedResult);
    }
}