package DataStructure.BackTracking;

/**
 * Basic Backtracking Implementation with N-Queens Problem
 */
public class BasicBacktracking {
    
    /**
     * N-Queens Problem: Place N queens on an NxN chessboard so that no two queens attack each other
     */
    public static class NQueens {
        private int n;
        private int[] queens; // queens[i] represents the column position of queen in row i
        private int solutions;

        public NQueens(int n) {
            this.n = n;
            this.queens = new int[n];
            this.solutions = 0;
        }

        // Check if placing a queen at (row, col) is safe
        private boolean isSafe(int row, int col) {
            // Check if any queen in previous rows can attack this position
            for (int i = 0; i < row; i++) {
                // Same column or same diagonal
                if (queens[i] == col || Math.abs(queens[i] - col) == Math.abs(i - row)) {
                    return false;
                }
            }
            return true;
        }

        // Solve N-Queens using backtracking
        public void solve() {
            solveNQueens(0);
            System.out.println("Total solutions for " + n + "-Queens: " + solutions);
        }

        private void solveNQueens(int row) {
            // Base case: all queens are placed
            if (row == n) {
                printSolution();
                solutions++;
                return;
            }

            // Try placing queen in each column of current row
            for (int col = 0; col < n; col++) {
                if (isSafe(row, col)) {
                    queens[row] = col; // Place queen
                    solveNQueens(row + 1); // Recur for next row
                    // Backtrack: remove queen (not needed in this case as we overwrite)
                }
            }
        }

        // Print the current solution
        private void printSolution() {
            System.out.println("Solution " + (solutions + 1) + ":");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (queens[i] == j) {
                        System.out.print("Q ");
                    } else {
                        System.out.print(". ");
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    /**
     * Subset Sum Problem: Find all subsets that sum to a target value
     */
    public static class SubsetSum {
        private int[] arr;
        private int target;
        private int[] solution;
        private int solutions;

        public SubsetSum(int[] arr, int target) {
            this.arr = arr;
            this.target = target;
            this.solution = new int[arr.length];
            this.solutions = 0;
        }

        public void findSubsets() {
            findSubsetSum(0, 0, 0);
            System.out.println("Total subsets with sum " + target + ": " + solutions);
        }

        private void findSubsetSum(int index, int currentSum, int count) {
            // Base case: if current sum equals target, print solution
            if (currentSum == target && count > 0) {
                printSubset(count);
                solutions++;
                return;
            }

            // Base case: if we've processed all elements
            if (index >= arr.length) {
                return;
            }

            // Include current element
            if (currentSum + arr[index] <= target) {
                solution[count] = arr[index];
                findSubsetSum(index + 1, currentSum + arr[index], count + 1);
            }

            // Exclude current element
            findSubsetSum(index + 1, currentSum, count);
        }

        private void printSubset(int count) {
            System.out.print("Subset " + (solutions + 1) + ": [");
            for (int i = 0; i < count; i++) {
                System.out.print(solution[i]);
                if (i < count - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }

    /**
     * Permutations: Generate all permutations of a string
     */
    public static class Permutations {
        private String str;
        private int count;

        public Permutations(String str) {
            this.str = str;
            this.count = 0;
        }

        public void generatePermutations() {
            generatePermutationsHelper("", str);
            System.out.println("Total permutations: " + count);
        }

        private void generatePermutationsHelper(String prefix, String remaining) {
            if (remaining.length() == 0) {
                System.out.println("Permutation " + (++count) + ": " + prefix);
                return;
            }

            for (int i = 0; i < remaining.length(); i++) {
                String newPrefix = prefix + remaining.charAt(i);
                String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
                generatePermutationsHelper(newPrefix, newRemaining);
            }
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        System.out.println("=== Basic Backtracking Examples ===\n");

        // Test N-Queens Problem
        System.out.println("1. N-Queens Problem (4x4):");
        NQueens nQueens = new NQueens(4);
        nQueens.solve();
        System.out.println();

        // Test Subset Sum Problem
        System.out.println("2. Subset Sum Problem:");
        int[] arr = {2, 3, 5, 6, 8, 10};
        int target = 10;
        SubsetSum subsetSum = new SubsetSum(arr, target);
        subsetSum.findSubsets();
        System.out.println();

        // Test Permutations
        System.out.println("3. String Permutations:");
        Permutations permutations = new Permutations("ABC");
        permutations.generatePermutations();
    }
}
