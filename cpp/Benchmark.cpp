#include <iostream>
#include <chrono>
#include <cmath>

bool is_prime(int n) {
    if (n <= 1) return false;
    for (int i = 2; i <= std::sqrt(n); i++) {
        if (n % i == 0) return false;
    }
    return true;
}

int fibonacci(int n) {
    if (n <= 1) return n;
    return fibonacci(n - 1) + fibonacci(n - 2);
}

int main() {
    auto start = std::chrono::high_resolution_clock::now();

    int primeCount = 0;
    for (int i = 2; i < 100000; i++) {
        if (is_prime(i)) primeCount++;
    }

    int fib = fibonacci(30); // Adding Fibonacci calculation for extra load

    auto end = std::chrono::high_resolution_clock::now();
    auto elapsed = std::chrono::duration_cast<std::chrono::milliseconds>(end - start);

    std::cout << "C++ Benchmark" << std::endl;
    std::cout << "Time taken: " << elapsed.count() << " ms" << std::endl;
    std::cout << "Prime count: " << primeCount << std::endl;
    std::cout << "Fibonacci number: " << fib << std::endl;

    return 0;
}
