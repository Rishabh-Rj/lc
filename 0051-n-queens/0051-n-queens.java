class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] x = new int[n];  // x[k] stores the column index for queen placed in row k
        solve(x, 0, n, result);
        return result;
    }

    // Recursive function to solve the N-Queens problem
    private void solve(int[] x, int k, int n, List<List<String>> result) {
        // Base case: If all queens are placed
        if (k == n) {
            result.add(construct(x, n));  // Add the solution to the result
            return;
        }

        // Try placing a queen in each column for the k-th row
        for (int i = 0; i < n; i++) {
            if (place(x, k, i)) {
                x[k] = i;  // Place the queen at row k and column i
                solve(x, k + 1, n, result);  // Recur to place the next queen
                // No need for explicit backtracking since we overwrite x[k] in the next loop
            }
        }
    }

    // Function to check if it's safe to place a queen at (k, i)
    private boolean place(int[] x, int k, int i) {
        for (int j = 0; j < k; j++) {
            // Check if any queen is in the same column or diagonals
            if (x[j] == i || Math.abs(x[j] - i) == Math.abs(j - k)) {
                return false;
            }
        }
        return true;
    }

    // Function to construct the board from the queen's positions
    private List<String> construct(int[] x, int n) {
        List<String> board = new ArrayList<>();
        for (int row = 0; row < n; row++) {
            char[] line = new char[n];
            for (int col = 0; col < n; col++) {
                line[col] = (x[row] == col) ? 'Q' : '.';
            }
            board.add(new String(line));
        }
        return board;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 4;  // Example with n = 4
        List<List<String>> result = solution.solveNQueens(n);
        System.out.println(result);
    }
}