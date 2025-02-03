package info.jab.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;

public class ConcurrentFibonacci {
    private final ExecutorService executor;
    private final ConcurrentHashMap<Integer, Long> cache;
    private final Semaphore semaphore;
    
    public ConcurrentFibonacci(int maxConcurrentTasks) {
        // Use virtual threads for lightweight concurrency
        this.executor = Executors.newVirtualThreadPerTaskExecutor();
        this.cache = new ConcurrentHashMap<>();
        this.semaphore = new Semaphore(maxConcurrentTasks);
        
        // Initialize base cases
        cache.put(0, 0L);
        cache.put(1, 1L);
    }
    
    public List<Long> calculateRange(int start, int end) throws InterruptedException, ExecutionException {
        List<Future<Long>> futures = new ArrayList<>();
        List<Long> results = new ArrayList<>();
        
        // Submit calculation tasks for each number in range
        for (int i = start; i <= end; i++) {
            final int n = i;
            futures.add(executor.submit(() -> calculateFibonacci(n)));
        }
        
        // Collect results in order
        for (Future<Long> future : futures) {
            results.add(future.get());
        }
        
        return results;
    }
    
    private Long calculateFibonacci(int n) throws InterruptedException {
        // Check cache first
        Long cached = cache.get(n);
        if (cached != null) {
            return cached;
        }
        
        // Base cases already in cache
        if (n <= 1) {
            return cache.get(n);
        }
        
        try {
            semaphore.acquire();
            
            // Double-check cache after acquiring semaphore
            cached = cache.get(n);
            if (cached != null) {
                return cached;
            }
            
            // Calculate sequentially to avoid thread explosion
            long n1 = calculateFibonacci(n - 1);
            long n2 = calculateFibonacci(n - 2);
            long result = n1 + n2;
            
            cache.put(n, result);
            return result;
            
        } finally {
            semaphore.release();
        }
    }
    
    public void shutdown() {
        executor.shutdown();
    }
}