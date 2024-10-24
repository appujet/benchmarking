import sys
import time
import math

# Increase the limit for converting large integers to strings
sys.set_int_max_str_digits(10000)  # You can adjust the limit as needed


def factorial(n):
    result = 1
    multiplication_count = 0  # Counter for multiplications
    for i in range(2, n + 1):
        result *= i
        multiplication_count += 1  # Increment the counter for each multiplication
    return result, multiplication_count  # Return both result and count


def factorial_digit_count(n):
    # Using logarithms to calculate the number of digits in n!
    if n == 0 or n == 1:
        return 1
    digit_count = sum(math.log10(i) for i in range(2, n + 1))
    return math.floor(digit_count) + 1


start_time = time.time()
result, count = factorial(10000)  # Get both result and count
digit_count = factorial_digit_count(
    10000
)  # Get digit count without converting to string
end_time = time.time()

print(f"Factorial has {digit_count} digits.")
print(f"Number of multiplications: {count}")  # Print the number of multiplications
print(
    f"Time taken: {round((end_time - start_time) * 1000)} milliseconds"
)  # Rounded time in milliseconds
