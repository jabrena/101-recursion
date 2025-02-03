package info.jab.recursion;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BubbleSortTest {

    private static Stream<Arguments> provideArraysForSorting() {
        return Stream.of(
            Arguments.of(
                new int[]{5, 1, 4, 2, 8},
                new int[]{1, 2, 4, 5, 8},
                "Regular array"
            ),
            Arguments.of(
                new int[]{},
                new int[]{},
                "Empty array"
            ),
            Arguments.of(
                new int[]{1},
                new int[]{1},
                "Single element"
            ),
            Arguments.of(
                new int[]{3, 1, 3, 2, 3},
                new int[]{1, 2, 3, 3, 3},
                "Duplicate elements"
            )
        );
    }

    @ParameterizedTest(name = "{2} Imperative")
    @MethodSource("provideArraysForSorting")
    public void shouldSortArray(int[] input, int[] expected, String testCase) {
        // Given
        BubbleSort bubbleSort = new BubbleSort();

        // When
        var result = bubbleSort.sort(input, input.length);

        // Then
        assertArrayEquals(expected, result);
    }

    @ParameterizedTest(name = "{2} Recursive")
    @MethodSource("provideArraysForSorting")
    public void shouldSortArray2(int[] input, int[] expected, String testCase) {
        // Given
        BubbleSort bubbleSort = new BubbleSort();

        // When
        var result = bubbleSort.sortRecursive(input, input.length);

        // Then
        assertArrayEquals(expected, result);
    }
} 