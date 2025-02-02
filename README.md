# 101 recursion

## Tail Recursion

Tail recursion is a special type of recursion where the recursive call is the last operation performed in the function. In other words, there are no pending calculations after the recursive call.

- [Factorial](src/main/java/info/jab/recursion/Factorial.java)

## Memoization

Memoization is a technique used to optimize recursive functions by storing the results of expensive function calls and reusing them when the same inputs occur again.

- [Fibonacci](src/main/java/info/jab/recursion/Fibonacci.java)

## How to build in local

```bash
sdk env install
./mvnw clean verify
```

## References

- https://www.geeksforgeeks.org/recursion-practice-problems-solutions/
- https://github.com/Birkbeck/sp3-example-code/tree/main/recursion/src/recursion