package info.jab.recursion;

public class ShowStackTrace {
    public static void recursiveMethod(int n) {
        if (n == 0) {
            printStack();
            return;
        }
        recursiveMethod(n - 1);
    }

    public static void printStack() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement element : stackTrace) {
            System.out.println(element);
        }
    }
}

