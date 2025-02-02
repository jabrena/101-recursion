# 101 recursion

## Concepts

### Tail Recursion

Tail recursion is a special type of recursion where the recursive call is the last operation performed in the function. In other words, there are no pending calculations after the recursive call.

- [Factorial](./src/main/java/info/jab/recursion/Factorial.java)

### Memoization

Memoization is a technique used to optimize recursive functions by storing the results of expensive function calls and reusing them when the same inputs occur again.

- [Fibonacci](./src/main/java/info/jab/recursion/Fibonacci.java)

## Utils

- [TailCall](./src/main/java/info/jab/recursion/utils/TailCall.java)
- [TailCalls](./src/main/java/info/jab/recursion/utils/TailCalls.java)
- [Memoizer](./src/main/java/info/jab/recursion/utils/Memoizer.java)

## How to build in local

```bash
sdk env install
./mvnw clean verify
```

## References

### Tail Recursion

- https://www.geeksforgeeks.org/recursion-practice-problems-solutions/
- https://github.com/Birkbeck/sp3-example-code/tree/main/recursion/src/recursion

### Functional Programming

- https://github.com/vavr-io/vavr
- https://github.com/aol/cyclops 
- https://github.com/aol/cyclops/blob/master/cyclops/src/main/java/cyclops/control/Trampoline.java
- https://github.com/fpinjava/fpinjava
- https://github.com/fpinjava/fpinjava/blob/master/fpinjava-parent/fpinjava-common/src/main/java/com/fpinjava/common/TailCall.java
- https://github.com/bodar/totallylazy
- https://github.com/bodar/totallylazy/blob/master/src/com/googlecode/totallylazy/Trampoline.java
