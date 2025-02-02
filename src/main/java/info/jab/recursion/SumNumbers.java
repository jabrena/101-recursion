package info.jab.recursion;

import java.util.stream.IntStream;

/**
 * Example 1 : Sum of Natural Numbers from 1 to 100
 */
public class SumNumbers {

    public int sumFirstHundredNumbers() {
        return IntStream.rangeClosed(1, 100).sum();
    }

    public int sumFirstHundredNumbersRecursive() {
        return sumRecursive(100);
    }
    
    private int sumRecursive(int n) {
        // base case
        if (n <= 1) {
            return 1;
        }
        // recursive case
        return n + sumRecursive(n - 1);
    }

}
