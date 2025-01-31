package info.jab.recursion;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    private final Factorial factorial = new Factorial();

    @Test
    void shouldCalculateFactorialForZero() {
        assertEquals(1, factorial.factorial(0));
    }

    @Test
    void shouldCalculateFactorialForOne() {
        assertEquals(1, factorial.factorial(1));
    }

    @Test
    void shouldCalculateFactorialForPositiveNumbers() {
        assertEquals(2, factorial.factorial(2));
        assertEquals(6, factorial.factorial(3));
        assertEquals(24, factorial.factorial(4));
        assertEquals(120, factorial.factorial(5));
    }

    @Test
    void shouldCalculateFactorialForLargerNumber() {
        assertEquals(3628800, factorial.factorial(10));
    }

    @Test
    void factorialRecursive_whenInputIsZero_returnsOne() {
        assertEquals(1, factorial.factorialRecursive(0));
    }

    @Test
    void factorialRecursive_whenInputIsOne_returnsOne() {
        assertEquals(1, factorial.factorialRecursive(1));
    }

    @Test
    void factorialRecursive_whenInputIsPositive_returnsCorrectResult() {
        assertEquals(120, factorial.factorialRecursive(5));
        assertEquals(3628800, factorial.factorialRecursive(10));
    }

    @Test
    void factorialRecursive_whenInputIsNegative_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> 
            factorial.factorialRecursive(-1)
        );
    }
} 