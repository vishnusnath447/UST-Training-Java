import org.example.Arithmetics;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticTest {
    private Arithmetics arithmetics = null;
    private int a,b;
    @BeforeTest
    void createObject(){
        arithmetics = new Arithmetics();
        a=10;
        b=5;
    }
    @AfterTest
    void destroyObject(){
        arithmetics = null;
        a=0;
        b=0;
    }

    @Test
    void testingSubtraction(){
        Assert.assertEquals(5,arithmetics.sub(a,b));
    }
    @Test(expectedExceptions = ArithmeticException.class)
    void testingDivision(){
        Assert.assertEquals(2,arithmetics.div(a,b));
        arithmetics.div(2,0);
    }
    @Test
    void testingMultiplication(){
        Assert.assertEquals(50,arithmetics.mul(a,b));
    }
    @Test
    void testingAddition(){
        Assert.assertEquals(15,arithmetics.add(a,b));
    }

    @Test
    void testingPrintEven(){
        List<Integer> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        result.add(2);
        result.add(4);
        result.add(6);
        result.add(8);
        Assert.assertEquals(result,arithmetics.printEven(list));
    }
}
