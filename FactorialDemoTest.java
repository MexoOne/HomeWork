//Testing FactorialDemo in TestNG

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FactorialDemoTest {

    @DataProvider
    public Object[][] positiveTests(){
        return new Integer[][]{
                {0, 1},
                {1, 1},
                {3, 6},
                {5, 120}
        };
    }

    @DataProvider
    public Object[][] negativeTests(){
        return new Integer[][]{
                {-1, -1},
                {-2, -1}
        };
    }

    @Test(dataProvider="positiveTests", description = "Positive tests")
    public void testFactorialPositive(int n, int nf){
        Assert.assertEquals(FactorialDemo.factorial(n), nf);
    }

    @Test(dataProvider="negativeTests", description = "Negative tests")
    public void testFactorialNegative(int n, int nf){
        Assert.assertEquals(FactorialDemo.factorial(n), nf);
    }
}