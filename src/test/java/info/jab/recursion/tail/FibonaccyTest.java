package info.jab.recursion.tail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;


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
    @DisplayName("Debe calcular correctamente los primeros números de Fibonacci")
    void testBasicFibonacciSequence() {
        // Los primeros números de la secuencia Fibonacci son: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
        assertEquals(0, fibonacci.fibonacciRecursive(0));
        assertEquals(1, fibonacci.fibonacciRecursive(1));
        assertEquals(1, fibonacci.fibonacciRecursive(2));
        assertEquals(2, fibonacci.fibonacciRecursive(3));
        assertEquals(3, fibonacci.fibonacciRecursive(4));
        assertEquals(5, fibonacci.fibonacciRecursive(5));
        assertEquals(8, fibonacci.fibonacciRecursive(6));
    }

    @Test
    @DisplayName("Debe lanzar IllegalArgumentException para números negativos")
    void testNegativeInput() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> fibonacci.fibonacciRecursive(-1)
        );
        assertEquals("Number must be non-negative", exception.getMessage());
    }

    @Test
    @DisplayName("Debe manejar correctamente números grandes de Fibonacci")
    void testLargerFibonacciNumber() {
        // El décimo número de Fibonacci es 55
        assertEquals(55, fibonacci.fibonacciRecursive(10));
    }

    @Disabled
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