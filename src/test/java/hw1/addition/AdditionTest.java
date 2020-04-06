package hw1.addition;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import hw1.BasicClass;

import static org.testng.Assert.*;

public class AdditionTest extends BasicClass{

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
}