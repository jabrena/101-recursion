package info.jab.recursion;

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
}
