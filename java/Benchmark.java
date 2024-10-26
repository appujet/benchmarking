import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.OperatingSystemMXBean;

public class Benchmark {

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();

        long startMemory = memoryBean.getHeapMemoryUsage().getUsed() / (1024 * 1024); // in MB

        @SuppressWarnings("unused")
        int primeCount = 0;
        for (int i = 2; i < 100000; i++) {
            if (isPrime(i)) primeCount++;
        }

        int fib = fibonacci(30); // Adding Fibonacci calculation for extra load

        long endTime = System.currentTimeMillis();
        long endMemory = memoryBean.getHeapMemoryUsage().getUsed() / (1024 * 1024); // in MB

        System.out.println("Java Benchmark");
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
        System.out.println("Fibonacci number: " + fib);
        System.out.println("Memory usage: " + (endMemory - startMemory) + " MB");
        System.out.println("Available processors: " + osBean.getAvailableProcessors());
    }
}
