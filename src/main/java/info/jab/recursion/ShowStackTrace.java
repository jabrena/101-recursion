package info.jab.recursion;

public class ShowStackTrace {
    public static void recursiveMethod(int n) {
        if (n == 0) return;
        
        printStack();
        recursiveMethod(n - 1);
    }

    public static void printStack() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        System.out.println(stackTrace.length);
    }
}

