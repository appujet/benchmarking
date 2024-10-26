import kotlin.system.measureTimeMillis

fun isPrime(n: Int): Boolean {
    if (n <= 1) return false
    for (i in 2..Math.sqrt(n.toDouble()).toInt()) {
        if (n % i == 0) return false
    }
    return true
}

fun fibonacci(n: Int): Int {
    if (n <= 1) return n
    return fibonacci(n - 1) + fibonacci(n - 2)
}

fun main() {
    val startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()

    var primes: List<Int> = listOf()
    var fib: Int = 0

    val elapsedTime = measureTimeMillis {
        primes = (2..100000).filter { isPrime(it) }
        fib = fibonacci(30)
    }

    val endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()
    val memoryUsage = (endMemory - startMemory) / (1024 * 1024) // in MB

    println("Kotlin Benchmark")
    println("Time taken: $elapsedTime ms")
    println("Fibonacci: $fib")
    println("Primes: ${primes.size}")
    println("Memory Usage: $memoryUsage MB")
}
