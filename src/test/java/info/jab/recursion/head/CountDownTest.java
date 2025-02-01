package info.jab.recursion.head;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CountDownTest {
    
    @Test
    void testCountDown() {
        StringBuilder result = new StringBuilder();
        CountDown.countDown(5, result);
        assertEquals("12345", result.toString());
    }
} 