package info.jab.recursion;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SortLargeArraysTest {

    private static final int ARRAY_SIZE = 50_000;

    private int[] generateConsecutiveArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }

    private int[] generateRandomArray(int[] input) {
        int[] array = input.clone();
        // Desordenar el array usando el algoritmo Fisher-Yates shuffle
        for (int i = array.length - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return array;
    }

    private int[] expectedResult;
    private int[] input;

    @BeforeEach
    void setUp() {
        expectedResult = generateConsecutiveArray(ARRAY_SIZE);
        input = generateRandomArray(expectedResult);
    }

    @Test
    void mergeSortLargeArraysTest() {
        MergeSort mergeSort = new MergeSort();
        int[] result = mergeSort.sort(input, 0, input.length - 1);
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void bubbleSortLargeArraysTest() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] result = bubbleSort.sort(input, input.length);
        assertArrayEquals(expectedResult, result);
    }
    
}
