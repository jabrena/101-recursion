package info.jab.recursion;

import info.jab.recursion.utils.Trampoline;

public class BubbleSort {
    
    public int[] sort(int[] arr, int n) {
        if (n == 1 || arr.length == 0) return arr;

        int[] result = arr.clone();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < result.length - 1; j++) {
                if (result[j] > result[j + 1]) {
                    // Intercambiar elementos
                    int temp = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = temp;
                }
            }
        }
        return result;
    }
    
    public int[] sortRecursive(int[] arr, int n) {
        return sortTail(arr, n).get();
    }

    // Recursive function to perform Bubble Sort
    public Trampoline<int[]> sortTail(int[] arr, int n) {
        // Base case: If the array has only one element or is empty, return the array
        if (n == 1 || arr.length == 0) return Trampoline.done(arr);

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
        return Trampoline.more(() -> sortTail(arr, n - 1));
    }
}

