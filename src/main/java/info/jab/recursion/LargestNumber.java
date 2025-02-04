package info.jab.recursion;

public class LargestNumber {

    public int largestNumber(int[] arr, int length, int result) {
        if (length == 1) return Math.max(arr[0], result);
        else return largestNumber(arr, length - 1, Math.max(arr[length - 1], result));
    }
}
