package info.jab.recursion.concurrent;

import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Long> {

    // The threshold determining when to split the task
    private static final int THRESHOLD = 1000;

    private final int[] array;
    private final int start;
    private final int end;

    public SumTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        // If the task is small enough, compute it directly
        if (end - start <= THRESHOLD) {
            return computeDirectly();
        }

        // Otherwise, split the task into two subtasks
        int middle = (start + end) / 2;

        // Create subtasks for each half
        SumTask leftTask = new SumTask(array, start, middle);
        SumTask rightTask = new SumTask(array, middle, end);

        // Fork the first task
        leftTask.fork();

        // Directly compute the second task
        long rightResult = rightTask.compute();

        // Join the results
        long leftResult = leftTask.join();

        // Return the combined result
        return leftResult + rightResult;
    }

    public long computeDirectly() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += array[i];
        }
        return sum;
    }
}
