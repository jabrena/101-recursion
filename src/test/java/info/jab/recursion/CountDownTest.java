package info.jab.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountDownTest {
    
    @Test
    void testCountDown() {
        StringBuilder result = new StringBuilder();
        CountDown.countDown(5, result);
        assertEquals("12345", result.toString());
    }
} 