# 101 recursion

![docs](./docs/recursion.jpg)

## Concepts

### Tail Call Optimization (TCO) 

Tail Call Optimization (TCO) is a compiler optimization technique that converts recursive tail calls into iterative loops. A tail call occurs when a recursive call is the last operation in a function.

Key benefits:
- Prevents stack overflow by reusing stack frames
- Improves memory usage and performance
- Turns recursion into iteration under the hood

**Note:** While Java doesn't support TCO natively, other JVM languages like Scala or Kotlin and functional programming languages do.

### Tail Recursion

Tail recursion is a special type of recursion where the recursive call is the last operation performed in the function. In other words, there are no pending calculations after the recursive call.

- [Factorial](./src/main/java/info/jab/recursion/Factorial.java)
- [Primes](./src/main/java/info/jab/recursion/Primes.java)

### Memoization

Memoization is a technique used to optimize recursive functions by storing the results of expensive function calls and reusing them when the same inputs occur again.

- [Fibonacci](./src/main/java/info/jab/recursion/Fibonacci.java)

### Divide and Conquer

Divide and Conquer is a recursive algorithmic strategy that breaks down a problem into smaller subproblems until they become simple enough to solve directly.

- [Merge Sort](./src/main/java/info/jab/recursion/MergeSort.java)

## Utils

- [TailCall](./src/main/java/info/jab/recursion/utils/TailCall.java)
- [TailCalls](./src/main/java/info/jab/recursion/utils/TailCalls.java)
- [Memoizer](./src/main/java/info/jab/recursion/utils/Memoizer.java)

## How to build in local

```bash
sdk env install
./mvnw clean verify
./mvnw clean verify surefire-report:report

./mvnw versions:display-dependency-updates
./mvnw versions:display-plugin-updates
```

## References

### Recursion in other JVM languages

- https://clojuredocs.org/clojure.core/recur
- https://www.scala-lang.org/api/3.1.2/scala/annotation/tailrec.html
- https://kotlinlang.org/docs/functions.html#tail-recursion


### Recursion

- https://www.geeksforgeeks.org/recursion-practice-problems-solutions/
- https://github.com/Birkbeck/sp3-example-code/tree/main/recursion/src/recursion

### Functional Programming

- https://github.com/vavr-io/vavr
- https://medium.com/@johnmcclean/trampolining-a-practical-guide-for-awesome-java-developers-4b657d9c3076
- https://github.com/aol/cyclops 
- https://github.com/aol/cyclops/blob/master/cyclops/src/main/java/cyclops/control/Trampoline.java
- https://github.com/fpinjava/fpinjava
- https://github.com/fpinjava/fpinjava/blob/master/fpinjava-parent/fpinjava-common/src/main/java/com/fpinjava/common/TailCall.java
- https://github.com/bodar/totallylazy
- https://github.com/bodar/totallylazy/blob/master/src/com/googlecode/totallylazy/Trampoline.java

### Property-Based Testing, PBT

- https://jqwik.net/
- https://github.com/jqwik-team
