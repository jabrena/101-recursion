package info.jab.recursion;

public class InfiniteRecursion {

    public void recurse() {
        ShowStackTrace.printStack();
        // This call never ends
        recurse();
    }
}
