package BigNumber;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.io.IOException;

/**
 * A prime number is a natural number greater than whose only positive divisors
 * are and itself. For example, the first six prime numbers are , , , , , and .
 * 
 * Given a large integer, , use the Java BigInteger class' isProbablePrime
 * method to determine and print whether it's prime or not prime.
 * 
 * Input Format
 * 
 * A single line containing an integer, (the number to be checked).
 * 
 * Constraints
 * 
 * contains at most digits.
 * Output Format
 * 
 * If is a prime number, print prime; otherwise, print not prime.
 * 
 * Sample Input
 * 
 * 13
 * Sample Output
 * 
 * prime
 * Explanation
 * 
 * The only positive divisors of are and , so we print prime.
 */

public class PrimeNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String n = bf.readLine();
        BigInteger number = new BigInteger(n);
        System.out.println(isPrime(number));
        bf.close();
    }

    private static String isPrime(BigInteger n) {
        if (n.isProbablePrime(1)) {
            return "prime";
        } else {
            return "not prime";
        }
    }
}
