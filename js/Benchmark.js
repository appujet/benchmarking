const os = require('node:os');
const startTime = Date.now();

function isPrime(n) {
    if (n <= 1) return false;
    for (let i = 2; i * i <= n; i++) {
        if (n % i === 0) return false;
    }
    return true;
}

function fibonacci(n) {
    if (n <= 1) return n;
    return fibonacci(n - 1) + fibonacci(n - 2);
}

function benchmark() {
    const initialMemory = process.memoryUsage().heapUsed / (1024 * 1024); // MB
    const initialCpuUsage = process.cpuUsage(); // Record CPU usage at the start

    const primes = [];
    for (let i = 2; i < 100000; i++) {
        if (isPrime(i)) primes.push(i);
    }

    const fib = fibonacci(30); // Adding Fibonacci calculation for extra load

    const elapsedTime = Date.now() - startTime;
    const finalMemory = process.memoryUsage().heapUsed / (1024 * 1024); // MB
    const cpuUsage = process.cpuUsage(initialCpuUsage); // Get CPU usage difference

    console.log("JavaScript Benchmark");
    console.log(`Time taken: ${elapsedTime} ms`);
    console.log(`Fibonacci number: ${fib}`);
    console.log(`Prime count: ${primes.length}`);
    console.log(`CPU Usage: ${cpuUsage.system} %`);
    console.log(`Memory Usage: ${(finalMemory - initialMemory).toFixed(2)} MB`);
}

benchmark();
