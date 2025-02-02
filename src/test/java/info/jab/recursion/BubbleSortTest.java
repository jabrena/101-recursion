package info.jab.recursion;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BubbleSortTest {

    @Test
    public void testBubbleSort() {
        // Arrange
        BubbleSort bubbleSort = new BubbleSort();
        int[] input = {5, 1, 4, 2, 8};
        int[] expected = {1, 2, 4, 5, 8};

        // Act
        bubbleSort.sort(input, input.length);

        // Assert
        assertArrayEquals(expected, input);
    }

    @Test
    public void testEmptyArray() {
        // Arrange
        BubbleSort bubbleSort = new BubbleSort();
        int[] input = {};
        int[] expected = {};

        // Act
        bubbleSort.sort(input, input.length);

        // Assert
        assertArrayEquals(expected, input);
    }

    @Test
    public void testSingleElement() {
        // Arrange
        BubbleSort bubbleSort = new BubbleSort();
        int[] input = {1};
        int[] expected = {1};

        // Act
        bubbleSort.sort(input, input.length);

        // Assert
        assertArrayEquals(expected, input);
    }

    @Test
    public void testDuplicateElements() {
        // Arrange
        BubbleSort bubbleSort = new BubbleSort();
        int[] input = {3, 1, 3, 2, 3};
        int[] expected = {1, 2, 3, 3, 3};

        // Act
        bubbleSort.sort(input, input.length);

        // Assert
        assertArrayEquals(expected, input);
    }
} 