import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomFunctionalInterfaceImplementationTest {
    private CustomFunctionalInterfaceImplementation customFunctionalInterfaceImplementation;

    @BeforeEach
    public void setUp(){
        customFunctionalInterfaceImplementation = new CustomFunctionalInterfaceImplementation();
    }

    @Test
    public void GivenAnInputStringAsNull(){
        assertEquals("Null String",customFunctionalInterfaceImplementation.myFunctionStr.doJob(null));
    }

    @Test
    void testGetChangedCaseWithoutNullInput() {
        assertEquals("STRiNG",customFunctionalInterfaceImplementation.myFunctionStr.doJob("strIng"));
    }
    @Test
    void testMyFunctionIntCaseWithNullInput() {
        assertEquals(null,customFunctionalInterfaceImplementation.myFunctionInt.doJob(null));
    }

    @Test
    void testMyFunctionIntWithoutNullInput(){
        assertEquals(27,customFunctionalInterfaceImplementation.myFunctionInt.doJob(3));
    }


    @AfterEach
    public void tareDown(){
        customFunctionalInterfaceImplementation = null;
    }
}
