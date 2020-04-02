package hw1.trigonometryFunc;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class CosinusTest {
    protected Calculator calculator;

    @BeforeMethod
    public void setCalculator(){
        calculator = new Calculator();
    }

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


    @AfterMethod
    public void tearDown(){
        calculator = null;
    }
}