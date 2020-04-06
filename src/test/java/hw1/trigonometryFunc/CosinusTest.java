package hw1.trigonometryFunc;

import hw1.BasicClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CosinusTest extends BasicClass {

    @DataProvider
    public Object[][] dataProviderArgs(){
        return new Object[][] {
                {0.0, 0.0000}
        };
    }

    @Test(dataProvider = "dataProviderArgs")
    public void cosMethodFailedTest(double a, double expectedResult){ //а в реализации специально допущена ошибка при вычислении косинуса?
        assertEquals(calculator.cos(Math.toRadians(a)), expectedResult);
    }
}