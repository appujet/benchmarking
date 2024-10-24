import java.math.BigInteger;

public class Hello {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        BigInteger result = factorial(10000); // Use BigInteger for large factorials
        long endTime = System.nanoTime();

        // Get the number of digits in the result
        int digitCount = countDigits(result);

        System.out.println("Factorial has " + digitCount + " digits.");
        System.out.println("Number of multiplications: " + (10000 - 1)); // Since we multiply from 2 to n
        System.out.println("Time taken: " + (endTime - startTime) / 1_000_000.0 + " milliseconds");
    }

    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }

    // Function to count the number of digits in a BigInteger
    public static int countDigits(BigInteger bigInteger) {
        return bigInteger.toString().length(); // Convert to string and get its length
    }
}
