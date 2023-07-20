import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static in.stackroute.Main.wordFrequency;

public class wordFrequencyTesting {
    @Test
    public void givingValidStringAndReturningFrequency(){
        Assertions.assertEquals(2,wordFrequency("Hello World"));
        Assertions.assertEquals(3,wordFrequency("Welcome to Java"));
    }
    @Test
    public void givingInvalidStringAndReturnZero(){
        Assertions.assertEquals(0,wordFrequency(""));
    }
}
