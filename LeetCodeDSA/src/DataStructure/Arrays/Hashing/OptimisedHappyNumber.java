package DataStructure.Arrays.Hashing;

import java.util.HashSet;
import java.util.Set;

public class OptimisedHappyNumber {
    public boolean findHappyNumber(int n) {
        Set<Integer> seen = new HashSet<>();

        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = sumOfSquares(n);
        }

        return n == 1;
    }

    private int sumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
    public static void main(String[] args) {
        OptimisedHappyNumber happyNumber = new OptimisedHappyNumber();
        System.out.println(happyNumber.findHappyNumber(19)); // Output: true
        System.out.println(happyNumber.findHappyNumber(2));  // Output: false
    }
}
