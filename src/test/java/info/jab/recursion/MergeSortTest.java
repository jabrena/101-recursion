package info.jab.recursion;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MergeSortTest {

    @Test
    public void testMergeSort() {
        // Arrange
        MergeSort mergeSort = new MergeSort();
        int[] input = {5, 1, 4, 2, 8};
        int[] expected = {1, 2, 4, 5, 8};

        // Act
        int[] result = mergeSort.sort(input, 0, input.length - 1);

        // Assert
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEmptyArray() {
        // Arrange
        MergeSort mergeSort = new MergeSort();
        int[] input = {};
        int[] expected = {};

        // Act
        int[] result = mergeSort.sort(input, 0, input.length - 1);

        // Assert
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSingleElement() {
        // Arrange
        MergeSort mergeSort = new MergeSort();
        int[] input = {1};
        int[] expected = {1};

        // Act
        int[] result = mergeSort.sort(input, 0, input.length - 1);

        // Assert
        assertArrayEquals(expected, result);
    }

    @Test
    public void testDuplicateElements() {
        // Arrange
        MergeSort mergeSort = new MergeSort();
        int[] input = {3, 1, 3, 2, 3};
        int[] expected = {1, 2, 3, 3, 3};

        // Act
        int[] result = mergeSort.sort(input, 0, input.length - 1);

        // Assert
        assertArrayEquals(expected, result);
    }
} 