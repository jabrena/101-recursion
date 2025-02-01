# 101 recursion

## Types of Recursion

### Direct Recursion

Direct recursion is called this way because the method calls itself "directly", without intermediaries.

- [Factorial](src/test/java/info/jab/recursion/direct/FactorialBenchmark.java)

### Indirect Recursion

Indirect recursion is when a method calls another method, which in turn calls the original method.

- [SumNumbers](src/test/java/info/jab/recursion/indirect/SumNumbersTest.java)

### Tail Recursion

Tail recursion is a special type of recursion where the recursive call is the last operation performed in the function. In other words, there are no pending calculations after the recursive call.

- [Fibonacci](src/test/java/info/jab/recursion/tail/FibonaccyTest.java)

### Head Recursion

Head recursion occurs when the recursive call is made before any other operation is processed in the function. In other words, the first operation in the method is the recursive call.

- [CountDown](src/test/java/info/jab/recursion/head/CountDownTest.java)

---

- Linear Recursion
- Multiple Recursion
- Nested Recursion

## How to build in local

```bash
sdk env install
./mvnw clean verify
```

## References

- https://www.javatpoint.com/different-types-of-recursions-in-java
- https://www.geeksforgeeks.org/recursion-practice-problems-solutions/