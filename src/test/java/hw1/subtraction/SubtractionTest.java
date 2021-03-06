package hw1.subtraction;

import hw1.BasicClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SubtractionTest extends BasicClass {

    @DataProvider
    public Object[][] dataProviderDouble(){
        return new Object[][] {
                {1.0, 0.0, 1.0},
                {0.0, 1.0, -1.0},
                {-1.0, -1.0, 0.0}
        };
    }
    @Test(dataProvider = "dataProviderDouble")
    public void subTwoDoubleTest(double a, double b, double expectedResult){
        assertEquals(calculator.sub(a, b), expectedResult);
    }

    @DataProvider
    public Object[][] dataProviderLong(){
        return new Object[][] {
                {1, 0, 1},
                {0, 1, -1},
                {-1, -1, 0}
        };
    }

    @Test(dataProvider = "dataProviderLong")
    public void subTwoLongTest(long a, long b, long expectedResult){
        assertEquals(calculator.sub(a, b), expectedResult);
    }
}