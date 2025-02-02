package info.jab.recursion;

public class InfiniteRecursion {
    public void recurse() {
        // This call never ends
        recurse();
    }
}
