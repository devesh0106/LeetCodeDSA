package DataStructure.DP;

/**
 * Basic Dynamic Programming Implementation with classic problems
 */
public class BasicDynamicProgramming {
    
    /**
     * Fibonacci Sequence using DP
     */
    public static class Fibonacci {
        
        // Recursive approach (inefficient)
        public static int fibRecursive(int n) {
            if (n <= 1) return n;
            return fibRecursive(n - 1) + fibRecursive(n - 2);
        }
        
        // DP approach with memoization
        public static int fibDP(int n) {
            if (n <= 1) return n;
            
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            
            return dp[n];
        }
        
        // Space optimized DP
        public static int fibOptimized(int n) {
            if (n <= 1) return n;
            
            int prev = 0, curr = 1;
            for (int i = 2; i <= n; i++) {
                int next = prev + curr;
                prev = curr;
                curr = next;
            }
            
            return curr;
        }
    }
    
    /**
     * Longest Common Subsequence (LCS)
     */
    public static class LongestCommonSubsequence {
        
        public static int lcs(String str1, String str2) {
            int m = str1.length();
            int n = str2.length();
            
            int[][] dp = new int[m + 1][n + 1];
            
            // Fill dp table
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            
            return dp[m][n];
        }
        
        public static String lcsString(String str1, String str2) {
            int m = str1.length();
            int n = str2.length();
            
            int[][] dp = new int[m + 1][n + 1];
            
            // Fill dp table
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            
            // Reconstruct the LCS
            StringBuilder lcs = new StringBuilder();
            int i = m, j = n;
            while (i > 0 && j > 0) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    lcs.insert(0, str1.charAt(i - 1));
                    i--;
                    j--;
                } else if (dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
            
            return lcs.toString();
        }
    }
    
    /**
     * 0/1 Knapsack Problem
     */
    public static class Knapsack {
        
        public static int knapsack01(int[] weights, int[] values, int capacity) {
            int n = weights.length;
            int[][] dp = new int[n + 1][capacity + 1];
            
            // Fill dp table
            for (int i = 1; i <= n; i++) {
                for (int w = 0; w <= capacity; w++) {
                    if (weights[i - 1] <= w) {
                        // Include current item
                        dp[i][w] = Math.max(dp[i - 1][w], 
                                          dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                    } else {
                        // Exclude current item
                        dp[i][w] = dp[i - 1][w];
                    }
                }
            }
            
            return dp[n][capacity];
        }
        
        public static void printSelectedItems(int[] weights, int[] values, int capacity) {
            int n = weights.length;
            int[][] dp = new int[n + 1][capacity + 1];
            
            // Fill dp table
            for (int i = 1; i <= n; i++) {
                for (int w = 0; w <= capacity; w++) {
                    if (weights[i - 1] <= w) {
                        dp[i][w] = Math.max(dp[i - 1][w], 
                                          dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                    } else {
                        dp[i][w] = dp[i - 1][w];
                    }
                }
            }
            
            // Backtrack to find selected items
            System.out.print("Selected items: ");
            int w = capacity;
            for (int i = n; i > 0 && w > 0; i--) {
                if (dp[i][w] != dp[i - 1][w]) {
                    System.out.print("Item " + i + " (weight: " + weights[i - 1] + 
                                   ", value: " + values[i - 1] + ") ");
                    w -= weights[i - 1];
                }
            }
            System.out.println();
        }
    }
    
    /**
     * Coin Change Problem
     */
    public static class CoinChange {
        
        // Minimum number of coins needed
        public static int minCoins(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            
            // Initialize with infinity
            for (int i = 1; i <= amount; i++) {
                dp[i] = Integer.MAX_VALUE;
            }
            
            // Fill dp table
            for (int i = 1; i <= amount; i++) {
                for (int coin : coins) {
                    if (coin <= i && dp[i - coin] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }
            
            return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
        }
        
        // Number of ways to make change
        public static int waysToMakeChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            dp[0] = 1; // Base case: one way to make 0 amount
            
            for (int coin : coins) {
                for (int i = coin; i <= amount; i++) {
                    dp[i] += dp[i - coin];
                }
            }
            
            return dp[amount];
        }
    }
    
    /**
     * Longest Increasing Subsequence (LIS)
     */
    public static class LongestIncreasingSubsequence {
        
        public static int lis(int[] arr) {
            int n = arr.length;
            int[] dp = new int[n];
            
            // Initialize dp array
            for (int i = 0; i < n; i++) {
                dp[i] = 1;
            }
            
            // Fill dp array
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
            
            // Find maximum value in dp array
            int max = 1;
            for (int i = 0; i < n; i++) {
                if (dp[i] > max) {
                    max = dp[i];
                }
            }
            
            return max;
        }
    }
    
    // Main method for testing
    public static void main(String[] args) {
        System.out.println("=== Basic Dynamic Programming Examples ===\n");
        
        // Test Fibonacci
        System.out.println("1. Fibonacci Sequence:");
        int n = 10;
        System.out.println("Fib(" + n + ") using DP: " + Fibonacci.fibDP(n));
        System.out.println("Fib(" + n + ") using optimized DP: " + Fibonacci.fibOptimized(n));
        System.out.println();
        
        // Test LCS
        System.out.println("2. Longest Common Subsequence:");
        String str1 = "ABCDGH";
        String str2 = "AEDFHR";
        System.out.println("LCS length: " + LongestCommonSubsequence.lcs(str1, str2));
        System.out.println("LCS string: " + LongestCommonSubsequence.lcsString(str1, str2));
        System.out.println();
        
        // Test Knapsack
        System.out.println("3. 0/1 Knapsack Problem:");
        int[] weights = {2, 1, 3, 2};
        int[] values = {12, 10, 20, 15};
        int capacity = 5;
        int maxValue = Knapsack.knapsack01(weights, values, capacity);
        System.out.println("Maximum value: " + maxValue);
        Knapsack.printSelectedItems(weights, values, capacity);
        System.out.println();
        
        // Test Coin Change
        System.out.println("4. Coin Change Problem:");
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println("Minimum coins needed: " + CoinChange.minCoins(coins, amount));
        System.out.println("Ways to make change: " + CoinChange.waysToMakeChange(coins, amount));
        System.out.println();
        
        // Test LIS
        System.out.println("5. Longest Increasing Subsequence:");
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60};
        System.out.println("LIS length: " + LongestIncreasingSubsequence.lis(arr));
    }
}
