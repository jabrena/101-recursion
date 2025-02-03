package info.jab.recursion.concurrent;

import java.math.BigInteger;
import java.util.concurrent.RecursiveTask;

public class FactorialTask extends RecursiveTask<BigInteger> {

    private final Integer number;

    public FactorialTask(Integer number) {
        this.number = number;
    }

    @Override
    protected BigInteger compute() {
        if (number <= 1) return BigInteger.ONE;

        FactorialTask ft = new FactorialTask(number - 1);
        ft.fork();
        
        return BigInteger.valueOf(number).multiply(ft.join());
    }
}