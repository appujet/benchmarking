package main

import (
    "fmt"
    "math"
    "runtime"
    "time"
)

func isPrime(n int) bool {
    if n <= 1 {
        return false
    }
    for i := 2; i <= int(math.Sqrt(float64(n))); i++ {
        if n%i == 0 {
            return false
        }
    }
    return true
}

func fibonacci(n int) int {
    if n <= 1 {
        return n
    }
    return fibonacci(n-1) + fibonacci(n-2)
}

func main() {
    start := time.Now()
    var m runtime.MemStats

    runtime.ReadMemStats(&m)
    startMemory := m.Alloc / 1024 / 1024 // in MB

    primeCount := 0
    for i := 2; i < 100000; i++ {
        if isPrime(i) {
            primeCount++
        }
    }

    fib := fibonacci(30) // Adding Fibonacci calculation for extra load

    runtime.ReadMemStats(&m)
    endMemory := m.Alloc / 1024 / 1024 // in MB

    fmt.Println("Go Benchmark")
    fmt.Printf("Time taken: %d ms\n", time.Since(start).Milliseconds())
    fmt.Printf("Fibonacci number: %d\n", fib)
    fmt.Printf("Prime count: %d\n", primeCount)
    fmt.Printf("Memory usage: %d MB\n", endMemory-startMemory)
}
