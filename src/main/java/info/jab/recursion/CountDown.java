package info.jab.recursion;

public class CountDown {

    public static void countDown(int n, StringBuilder result) {
        if (n <= 0) {
            return;
        }
        
        // The recursive call happens before processing n
        countDown(n - 1, result);
        result.append(n);
    }
}