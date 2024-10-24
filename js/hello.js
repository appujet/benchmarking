let multiplicationCount = 0;  // Initialize the multiplication counter

function factorial(n) {
    if (n === 0) {
        return BigInt(1);
    } else {
        multiplicationCount++;  // Increment the counter for each multiplication
        return BigInt(n) * factorial(n - 1);
    }
}

// Function to calculate the number of digits in a BigInt
function countDigits(bigInt) {
    return bigInt.toString().length; // Convert to string and get its length
}

const startTime = new Date().getTime();
const result = factorial(10000);  // Calculate factorial using BigInt
const endTime = new Date().getTime();

const digitCount = countDigits(result); // Get the number of digits in the result

console.log(`Factorial has ${digitCount} digits.`);
console.log(`Number of multiplications: ${multiplicationCount}`);  // Log the number of multiplications
console.log(`Time taken: ${endTime - startTime} milliseconds`); // Log the time taken
