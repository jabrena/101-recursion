package info.jab.recursion.concurrent;

import java.util.Set;
import java.util.concurrent.RecursiveAction;

/**
 * Example implementation of {@link RecursiveAction} to compute prime numbers up
 * to defined limit
 * 
 * @author pavel.sklenar
 * 
 */
class PrimeRecursiveAction extends RecursiveAction {

	private static final long serialVersionUID = -7792426435156607324L;
	private int threshold;
	private Set<Integer> data;
	private int start;
	private int end;

	public PrimeRecursiveAction(Set<Integer> data, int start, int end,
			int threshold) {
		this.data = data;
		this.start = start; // start to process from
		this.end = end; // end of processing
		this.threshold = threshold;
	}
	
	@Override
	protected void compute() {
		if (end - start <= threshold) { // Am I able to process it alone?
			// do the task
			for (int i = start; i < end; i++) {
				if (PrimeNumberUtil.isPrime(i)) {
					data.add(i);
				}
			}
		} else { // split too big task
			int halfAmount = ((end - start) / 2) + start;
			PrimeRecursiveAction leftTask = new PrimeRecursiveAction(data,
					start, halfAmount, threshold);
			leftTask.fork(); // add left task to the queue
			PrimeRecursiveAction rightTask = new PrimeRecursiveAction(data,
					halfAmount, end, threshold);
			rightTask.compute(); // work on right task, this is a recursive call
			leftTask.join(); // wait for queued task to be completed
			//The following code can replace lines with calling fork, compute and join
			//invokeAll(rightTask, leftTask);
		}
	}
}
