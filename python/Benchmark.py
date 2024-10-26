import time
import psutil
import math

def is_prime(n):
    if n <= 1:
        return False
    for i in range(2, int(math.sqrt(n)) + 1):
        if n % i == 0:
            return False
    return True

def fibonacci(n):
    if n <= 1:
        return n
    else:
        return fibonacci(n - 1) + fibonacci(n - 2)

def benchmark():
    start_time = time.time() * 1000
    start_cpu = psutil.cpu_percent(interval=None)
    start_memory = psutil.virtual_memory().used / (1024 * 1024)  # in MB

    # Perform prime calculation for added load
    primes = [x for x in range(2, 100000) if is_prime(x)]
    fib = fibonacci(30)  # Adding Fibonacci calculation for extra load

    end_time = time.time() * 1000
    end_cpu = psutil.cpu_percent(interval=None)
    end_memory = psutil.virtual_memory().used / (1024 * 1024)  # in MB

    print("Python Benchmark")
    print(f"Time taken: {end_time - start_time:.2f} ms")
    print(f"Fibonacci number: {fib}")
    print(f"Prime count: {len(primes)}")
    print(f"CPU Usage: {end_cpu - start_cpu:.2f}%")
    print(f"Memory Usage: {end_memory - start_memory:.2f} MB")

if __name__ == "__main__":
    benchmark()
