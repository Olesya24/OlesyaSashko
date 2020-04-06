package hw1.multiplication;

import hw1.BasicClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MultiplicationTest extends BasicClass {

    @DataProvider
    public Object[][] dataProviderDouble(){
        return new Object[][] {
                {10.0, 2.0, 20.0},
                {-2.0, 5.0, -10.0},
                {0.0, 22.0, 0.0}
        };
    }
    @Test(dataProvider = "dataProviderDouble")
    public void multTwoDoubleTest(double a, double b, double expectedResult){
        assertEquals(calculator.mult(a, b), expectedResult);
    }

    @DataProvider
    public Object[][] dataProviderLong(){
        return new Object[][] {
                {10, 2, 20},
                {-2, 5, -10},
                {0, 22, 0}
        };
    }

    @Test(dataProvider = "dataProviderLong")
    public void multTwoLongTest(long a, long b, long expectedResult){
        assertEquals(calculator.mult(a, b), expectedResult);
    }
}