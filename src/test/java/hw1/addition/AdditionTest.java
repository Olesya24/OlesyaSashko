package hw1.addition;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AdditionTest {
    protected Calculator calculator;

    @BeforeMethod
    public void setCalculator(){
        calculator = new Calculator();
    }

    @DataProvider
    public Object[][] dataProviderDouble() {
        return new Object[][]{
                {0.1, 1.0, 1.1},
                {0.2, 0.8, 1.0},
                {-1.0, -1.0, -2.0}
        };
    }

    @Test(dataProvider = "dataProviderDouble")
    public void sumTwoDoublesTest(double a, double b, double expectedResult){
        assertEquals(calculator.sum(a, b), expectedResult);
    }


    @DataProvider
    public Object[][] dataProviderLong() {
        return new Object[][]{
                {0, 2, 2},
                {2, 8, 10},
                {100, 11, 111},
                {-1, -1, -2}
        };
    }

    @Test(dataProvider = "dataProviderLong")
    public void sumTwoLongTest(long a, long b, long expectedResult){
        assertEquals(calculator.sum(a, b), expectedResult);
    }

    @AfterMethod
    public void tearDown(){
        calculator = null;
    }
}