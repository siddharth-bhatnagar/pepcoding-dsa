/**
 * Blog: https://takeuforward.org/data-structure/minimum-path-sum-in-a-grid-dp-10/
 * Leetcode 64
 */
public class MinPathSumGrid {
    public int minPathSum(int[][] grid) {
        return spaceOp(grid);
    }

    // f(i, j) -> returns the minCost of path from (i,j) to (0,0)
    // O(2^(mxn)), O(pathLength)
    private int f(int[][] grid, int i, int j) {
        if (i == 0 && j == 0) return grid[0][0];
        if (i < 0 || j < 0) return Integer.MAX_VALUE;

        int up = grid[i][j] + f(grid, i-1, j);
        int left = grid[i][j] + f(grid, i, j-1);

        return Math.min(up, left);
    }

    // O(MxN), O(pathLength + MxN)
    private int memoized(int[][] grid, int i, int j, int[][] dp) {
        if (i == 0 && j == 0) return dp[0][0] = grid[0][0];
        if (i < 0 || j < 0) return Integer.MAX_VALUE;

        if (dp[i][j] != -1) return dp[i][j];

        int up = grid[i][j] + memoized(grid, i-1, j, dp);
        int left = grid[i][j] + memoized(grid, i, j-1, dp);

        return dp[i][j] = Math.min(up, left);
    }
    
    // O(MxN), O(MxN)
    private int tabulation(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = grid[0][0];
                } else {
                    int up = grid[i][j];
                    if (i > 0) up += dp[i - 1][j];
                    else up = Integer.MAX_VALUE;
                    int left = grid[i][j];
                    if (j > 0) left += dp[i][j - 1];
                    else left = Integer.MAX_VALUE;

                    dp[i][j] = Math.min(up, left);
                }
            }
        }

        return dp[m-1][n-1];
    }

    // O(MxN), O(N * 2)
    private int spaceOp(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] prev = new int[n];

        for (int i = 0; i < m; i++) {
            int curr[] = new int[n];
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    curr[0] = grid[0][0];
                } else {
                    int up = grid[i][j];
                    if (i > 0) up += prev[j];
                    else up = Integer.MAX_VALUE;
                    int left = grid[i][j];
                    if (j > 0) left += curr[j - 1];
                    else left = Integer.MAX_VALUE;

                    curr[j] = Math.min(up, left);
                }
            }
            prev = curr;
        }

        return prev[n-1];
    }
}
