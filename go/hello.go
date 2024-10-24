package main

import (
    "fmt"
    "math/big"
    "time"
)

var multiplicationCount int // Variable to count the number of multiplications

// Factorial function that calculates the factorial recursively
func factorial(n int) *big.Int {
    if n == 0 {
        return big.NewInt(1)
    } else {
        multiplicationCount++ // Increment the count for each multiplication
        return new(big.Int).Mul(big.NewInt(int64(n)), factorial(n-1))
    }
}

// Function to count the number of digits in a big.Int
func countDigits(num *big.Int) int {
    return len(num.String()) // Convert to string and get its length
}

func main() {
    startTime := time.Now()
    result := factorial(10000)
    endTime := time.Now()

    digitCount := countDigits(result) // Get the number of digits in the result

    fmt.Printf("Factorial has %d digits.\n", digitCount) // Print the number of digits
    fmt.Printf("Number of multiplications: %d\n", multiplicationCount) // Log the number of multiplications
    fmt.Printf("Time taken: %d milliseconds\n", endTime.Sub(startTime).Milliseconds()) // Print in milliseconds
}
