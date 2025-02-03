package info.jab.recursion;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.StructuredTaskScope.Subtask;

public class Primes {
    
    public boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        
        for (int divisor = 2; divisor * divisor <= n; divisor++) {
            if (n % divisor == 0) return false;
        }
        return true;
    }

    // Indirect recursion
    public boolean isPrimeRecursive(int n) {
        if (n == 2) return true; // Special case: 2 is prime
        return isPrimeTailRec(n, 2); // Start checking from 2
    }

    private boolean isPrimeTailRec(int n, int divisor) {
        // Base cases
        if (n < 2) return false; // Numbers less than 2 are not prime
        if (divisor * divisor > n) return true; // If divisor^2 > n, it's prime
        if (n % divisor == 0) return false; // If divisible, not prime
        
        // Recursive call with next divisor
        return isPrimeTailRec(n, divisor + 1);
    }

    public boolean isPrimeConcurrent(int n) throws InterruptedException, ExecutionException {
        if (n < 2) return false;
        if (n == 2) return true;
        
        int sqrtN = (int) Math.sqrt(n);
        return isPrimeRecursiveConcurrent(n, 2, sqrtN);
    }
    
    private boolean isPrimeRecursiveConcurrent(int n, int start, int end) throws InterruptedException, ExecutionException {        
        System.out.println("Thread: " + Thread.currentThread() + " - Checking range: " + start + " to " + end);
        
        int mid = start + (end - start) / 2;
        
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            Subtask<Boolean> leftTask = scope.fork(() -> 
                isPrimeRecursiveConcurrent(n, start, mid));
                
            Subtask<Boolean> rightTask = scope.fork(() -> 
                isPrimeRecursiveConcurrent(n, mid + 1, end));
            
            scope.join().throwIfFailed();
            return leftTask.get() && rightTask.get();
        }
    }
}
