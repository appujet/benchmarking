use std::time::Instant;
use sysinfo::{System, SystemExt}; // Import the necessary traits

fn is_prime(n: u32) -> bool {
    if n <= 1 {
        return false;
    }
    for i in 2..=((n as f64).sqrt() as u32) {
        if n % i == 0 {
            return false;
        }
    }
    true
}

fn fibonacci(n: u32) -> u32 {
    if n <= 1 {
        return n;
    }
    fibonacci(n - 1) + fibonacci(n - 2)
}

fn main() {
    let mut sys = System::new_all();
    sys.refresh_memory();

    let start = Instant::now();
    let start_memory = sys.used_memory() / 1024; // in MB

    let primes: Vec<u32> = (2..100000).filter(|&x| is_prime(x)).collect();
    let fib = fibonacci(30);

    let elapsed = start.elapsed().as_millis();
    sys.refresh_memory(); // Refresh to get updated memory usage
    let end_memory = sys.used_memory() / 1024; // in MB

    println!("Rust Benchmark");
    println!("Time taken: {} ms", elapsed);
    println!("Fibonacci number: {}", fib);
    println!("Prime count: {}", primes.len());
    println!("Memory Usage: {} MB", end_memory as i64 - start_memory as i64);
}
