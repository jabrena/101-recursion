package info.jab.recursion.concurrent;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;

class ConcurrentFibonacciTest {

    @Test
    void shouldReturnCorrectValueForSingleNumber() throws Exception {
        // Given
        ConcurrentFibonacci calculator = new ConcurrentFibonacci(5);
        long[] expectedFibonacci = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55};
        
        // When
        List<Long> results = calculator.calculateRange(0, 10);
        calculator.shutdown();

        // Then
        assertThat(results)
            .as("La secuencia de Fibonacci")
            .hasSize(expectedFibonacci.length)
            .containsExactly(Arrays.stream(expectedFibonacci).boxed().toArray(Long[]::new));
    }

} 