package hw1.division;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DivisionTest {

    protected Calculator calculator;

    @BeforeMethod
    public void setCalculator(){
        calculator = new Calculator();
    }

    @DataProvider
    public Object[][] dataProviderDouble(){
        return new Object[][] {
                {10.0, 2.0, 5.0},
                {10.0, 20.0, 0.5},
                {0.0, 10.0, 0.0},
                {-10.0, 5.0, -2.0}
        };
    }
    @Test(dataProvider = "dataProviderDouble")
    public void divTwoDoubleTest(double a, double b, double expectedResult){
        assertEquals(calculator.div(a, b), expectedResult);
    }

    @DataProvider
    public Object[][] dataProviderLong(){
        return new Object[][] {
                {10, 2, 5},
                {0, 10, 0},
                {-10, 5, -2}
        };
    }

    @Test(dataProvider = "dataProviderLong")
    public void divTwoLongTest(long a, long b, long expectedResult){
        assertEquals(calculator.div(a, b), expectedResult);
    }

    @AfterMethod
    public void tearDown(){
        calculator = null;
    }
}