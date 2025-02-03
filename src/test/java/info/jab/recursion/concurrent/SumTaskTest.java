package info.jab.recursion.concurrent;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SumTaskTest {
    
    @Test
    void shouldWork() {
        // Given
        int[] numbers = new int[10_000_000];
        Arrays.fill(numbers, 1); // Fill with 1s for easy verification
        SumTask task = new SumTask(numbers, 0, numbers.length);
        var expectedSum = task.computeDirectly();

        // When
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        var result = forkJoinPool.invoke(task);
        forkJoinPool.shutdown();

        // Then
        assertThat(result).isEqualTo(expectedSum);
    }
}
