using System;
using System.Diagnostics;
using System.Numerics;

var stopwatch = Stopwatch.StartNew();
BigInteger result = CalculateFactorial(10000);
stopwatch.Stop();

int digitCount = CountDigits(result); // Get the number of digits in the result

Console.WriteLine($"Factorial has {digitCount} digits."); // Print the number of digits
Console.WriteLine($"Number of multiplications: {10000 - 1}"); // Log the number of multiplications
Console.WriteLine($"Time taken: {stopwatch.ElapsedMilliseconds} milliseconds"); // Print in milliseconds

BigInteger CalculateFactorial(int n)
{
    BigInteger result = 1; // Initialize result as BigInteger

    for (int i = 2; i <= n; i++)
    {
        result *= i; // Multiply the result by each number
    }

    return result; // Return the final result
}

// Function to count the number of digits in a BigInteger
int CountDigits(BigInteger bigInteger)
{
    return bigInteger.ToString().Length; // Convert to string and get its length
}
