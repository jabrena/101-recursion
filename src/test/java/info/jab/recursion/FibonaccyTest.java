package info.jab.recursion;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;

@Disabled
class FibonaccyTest {

    private final Fibonaccy fibonacci = new Fibonaccy();

    @Test
    @DisplayName("Debe manejar casos base correctamente")
    void testBaseCases() {
        assertEquals(0, fibonacci.fibonacci(0));
        assertEquals(0, fibonacci.fibonacciRecursive(0));
        assertEquals(1, fibonacci.fibonacci(1));
        assertEquals(1, fibonacci.fibonacciRecursive(1));
    }

    @Test
    @DisplayName("Debe calcular números de Fibonacci correctamente")
    void testFibonacciSequence() {
        // Probando los primeros números de Fibonacci
        long[] expectedSequence = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34};
        
        for (int i = 0; i < expectedSequence.length; i++) {
            assertEquals(expectedSequence[i], fibonacci.fibonacci(i));
            assertEquals(expectedSequence[i], fibonacci.fibonacciRecursive(i));
        }
    }

    @Test
    @DisplayName("Debe lanzar excepción para números negativos")
    void testNegativeNumbers() {
        Exception exception = assertThrows(IllegalArgumentException.class, 
            () -> fibonacci.fibonacci(-1));
        assertEquals("Number must be non-negative", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, 
            () -> fibonacci.fibonacciRecursive(-1));
        assertEquals("Number must be non-negative", exception.getMessage());
    }

    @Test
    @DisplayName("Debe manejar números grandes correctamente")
    void testLargeNumbers() {
        // El 40º número de Fibonacci es 102334155
        assertEquals(102334155L, fibonacci.fibonacci(40));
        assertEquals(102334155L, fibonacci.fibonacciRecursive(40));
    }

    @Test
    @DisplayName("Should handle edge cases and verify performance")
    void testEdgeCasesAndPerformance() {
        // Testing with a moderately large number that shouldn't cause stack overflow
        assertTimeout(Duration.ofSeconds(5), () -> {
            assertEquals(1134903170L, fibonacci.fibonacci(45));
            assertEquals(1134903170L, fibonacci.fibonacciRecursive(45));
        });
        
        // Testing maximum safe input before potential overflow
        assertDoesNotThrow(() -> fibonacci.fibonacci(92));
        assertDoesNotThrow(() -> fibonacci.fibonacciRecursive(92));
    }
} 