package info.jab.recursion;

import info.jab.recursion.utils.TailCall;
import static info.jab.recursion.utils.TailCalls.call;
import static info.jab.recursion.utils.TailCalls.done;

public class BubbleSort {
    
    // Recursive function to perform Bubble Sort
    public TailCall<int[]> sortTail(int[] arr, int n) {
        // Base case: If the array has only one element or is empty, return the array
        if (n == 1 || arr.length == 0) return done(arr);

        // Perform one pass: push the largest element to the end
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                // Swap arr[i] and arr[i + 1]
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }

        // Recursive call for remaining elements
        return call(() -> sortTail(arr, n - 1));
    }

    public int[] sort(int[] arr, int n) {
        return sortTail(arr, n).invoke();
    }
}

