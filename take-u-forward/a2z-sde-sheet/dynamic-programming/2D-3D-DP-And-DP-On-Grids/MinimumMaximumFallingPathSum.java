/**
 * Leetcode 931
 * Blog: https://takeuforward.org/data-structure/minimum-maximum-falling-path-sum-dp-12/
 */
public class MinimumMaximumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        // int[][] dp = new int[n][m];
        // for (int i = 0;i<n;i++) {
        //     Arrays.fill(dp[i], -1);
        // }

        // int omin = Integer.MAX_VALUE;
        // for(int j=0;j<matrix[0].length;j++) {
        //     int min = memoized(matrix.length-1, j, matrix, dp);
        //     omin = Math.min(omin, min);
        // }
        // return omin;
        // return tabulation(matrix, n, m);
        return spaceOp(matrix, n, m);
    }

    // Here, we have variable starting and ending points.
    // Only thing we know is starting point can be any of the cell from row 0
    // Ending point can be any of the cell from row n - 1.
    // We can use recursion to check for all ways and then optimise it.
    // f(i, j) -> the min cost of reaching the first row from the cell (i, j)
    // O(Exponential), O(N)
    private int f(int i, int j, int[][] matrix) {
        // Base Cases
        if (j < 0 || j > matrix[0].length - 1) {
            return (int) Math.pow(10, 9);
        }

        if (i == 0) {
            return matrix[0][j];
        }

        int ld = matrix[i][j] + f(i-1, j-1, matrix);
        int up = matrix[i][j] + f(i-1, j, matrix);
        int rd = matrix[i][j] + f(i-1, j+1, matrix);

        return Math.min(ld, Math.min(up, rd));
    }
    
    // O(MxN), O(MxN + N)
    private int memoized(int i, int j, int[][] matrix, int[][] dp) {
        if (j < 0 || j > matrix[0].length - 1) {
            return (int) Math.pow(10, 9);
        }

        if (i == 0) {
            return dp[i][j] = matrix[0][j];
        }

        if (dp[i][j] != -1) return dp[i][j];

        int ld = matrix[i][j] + memoized(i-1, j-1, matrix, dp);
        int up = matrix[i][j] + memoized(i-1, j, matrix, dp);
        int rd = matrix[i][j] + memoized(i-1, j+1, matrix, dp);

        return dp[i][j] = Math.min(ld, Math.min(up, rd));
    }

    // O(MxN), O(MxN)
    private int tabulation(int[][] matrix, int n, int m) {
        int[][] dp = new int[n][m];

        // Base case
        for (int j=0;j<m;j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i<n; i++) {
            for (int j = 0; j < m; j++) {
                int ld = matrix[i][j];
                if (j-1 < 0) {
                    ld += (int) Math.pow(10, 9);
                }
                else ld += dp[i-1][j-1];
                int up = matrix[i][j] + dp[i-1][j];

                int rd = matrix[i][j]; 
                if (j + 1 > m - 1) {
                    rd += (int) Math.pow(10, 9);
                }
                else rd += dp[i-1][j+1];

                dp[i][j] = Math.min(Math.min(ld, rd), up);
            }
        }

        int omin = Integer.MAX_VALUE;
        for (int j=0;j<m;j++) {
            omin = Math.min(omin, dp[n-1][j]);
        }

        return omin;
    } 

    // O(MxN), O(N *2)
    private int spaceOp(int[][] matrix, int n, int m) {
        int[] prev = new int[n];

        // Base case
        for (int j=0;j<m;j++) {
            prev[j] = matrix[0][j];
        }

        for (int i = 1; i<n; i++) {
            int[] curr = new int[n];
            for (int j = 0; j < m; j++) {
                int ld = matrix[i][j];
                if (j-1 < 0) {
                    ld += (int) Math.pow(10, 9);
                }
                else ld += prev[j-1];
                int up = matrix[i][j] + prev[j];

                int rd = matrix[i][j]; 
                if (j + 1 > m - 1) {
                    rd += (int) Math.pow(10, 9);
                }
                else rd += prev[j+1];

                curr[j] = Math.min(Math.min(ld, rd), up);
            }
            prev = curr;
        }

        int omin = Integer.MAX_VALUE;
        for (int j=0;j<m;j++) {
            omin = Math.min(omin, prev[j]);
        }

        return omin;
    }
}
