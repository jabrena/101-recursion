package info.jab.recursion.head;

public class CountDown {

    public static void countDown(int n, StringBuilder result) {
        if (n <= 0) {
            return;
        }
        
        // La llamada recursiva ocurre antes de procesar n
        countDown(n - 1, result);
        result.append(n);
    }
}