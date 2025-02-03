package info.jab.recursion.concurrent;

import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.StructuredTaskScope.Subtask;

public class ConcurrentMergeSort {

    // Main function that sorts the array using concurrent merge sort
    public int[] sort(int[] arr, int left, int right) throws InterruptedException {

        int mid = left + (right - left) / 2;
        
        // Use structured concurrency to sort both halves in parallel
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            // Fork both sorting tasks
            Subtask<int[]> leftFuture = scope.fork(() -> {
                int[] leftArr = arr.clone();
                return sort(leftArr, left, mid);
            });
            
            Subtask<int[]> rightFuture = scope.fork(() -> {
                int[] rightArr = arr.clone();
                return sort(rightArr, mid + 1, right);
            });
            
            // Wait for both tasks to complete
            scope.join();
            
            // Get results
            int[] leftResult = leftFuture.get();
            int[] rightResult = rightFuture.get();
            
            // Merge the sorted halves
            return merge(leftResult, rightResult, left, mid, right);
        }
    }

    // Modified merge function to handle two separate arrays
    private int[] merge(int[] leftArr, int[] rightArr, int left, int mid, int right) {
        int[] result = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        
        while (i <= mid && j <= right) {
            if (leftArr[i] <= rightArr[j]) {
                result[k++] = leftArr[i++];
            } else {
                result[k++] = rightArr[j++];
            }
        }
        
        while (i <= mid) {
            result[k++] = leftArr[i++];
        }
        
        while (j <= right) {
            result[k++] = rightArr[j++];
        }
        
        return result;
    }
}
