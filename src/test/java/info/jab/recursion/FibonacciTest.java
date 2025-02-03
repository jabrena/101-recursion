package info.jab.recursion;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigInteger;

class FibonacciTest {

    private final Fibonacci fibonacci = new Fibonacci();

    @ParameterizedTest
    @DisplayName("Should correctly calculate the first Fibonacci numbers")
    @CsvFileSource(resources = "/fibonacci-test-data.txt")
    void testBasicFibonacciSequence(int input, BigInteger expectedResult) {
        assertEquals(expectedResult, fibonacci.fibonacci(input));
        assertEquals(expectedResult, fibonacci.fibonacciRecursive(input));
        assertEquals(expectedResult, fibonacci.fibonacciTailCall(input));
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException for negative numbers")
    void testNegativeInput() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> fibonacci.fibonacciRecursive(-1)
        );
        assertEquals("Number must be non-negative", exception.getMessage());
    }
} 