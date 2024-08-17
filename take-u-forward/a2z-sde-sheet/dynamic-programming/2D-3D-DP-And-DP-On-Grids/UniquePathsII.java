/**
 * Blog: https://takeuforward.org/data-structure/grid-unique-paths-2-dp-9/
 * Leetcode 63
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        return spaceOp(m, n, obstacleGrid);
    }

    // f(i, j) -> returns the count of paths from (i,j) to (0,0)
    // O(2^(mxn)), O(pathLength)
    private int f(int i, int j, int[][] grid) {
        if (i>0 && j > 0 && grid[i][j] == 1) return 0;
        if (i==0 && j==0) {
            if (grid[0][0] == 0) 
                return 1;

            return 0;
        }
        if (i < 0 || j < 0) return 0;

        int up = f(i-1, j, grid);
        int left = f(i, j-1, grid);

        return up + left;
    }

    // O(MxN), O(pathLength + MxN)
    private int memoized(int i, int j, int[][] dp, int[][] grid) {
        if (i>0 && j > 0 && grid[i][j] == 1) return dp[i][j] = 0;
        if (i==0 && j==0) {
            if (grid[0][0] == 0) 
                return dp[0][0] = 1;

            return 0;
        }
        if (i < 0 || j < 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int up = f(i-1, j, grid);
        int left = f(i, j-1, grid);

        return dp[i][j] = up + left;
    }

    // O(MxN), O(MxN)
    private int tabulation(int m, int n, int[][] grid) {
        int[][] dp = new int[m][n];
        if (grid[0][0] == 1) return 0;

        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (grid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }

                if (i==0&&j==0) {
                    dp[0][0] = 1;
                    continue;
                }
                int up = 0;
                if (i > 0) up = dp[i-1][j];
                int left = 0;
                if (j > 0) left = dp[i][j-1];

                dp[i][j] = up + left;
            }
        }

        return dp[m-1][n-1];
    }

    // space optimisation -> only need to maintain the previous row results and can maintain current row results.
    // O(MxN), O(N);
    private int spaceOp(int m, int n, int[][] grid) {
        int[] prev = new int[n];

        for (int i=0;i<m;i++) {
            int[] curr = new int[n];
            for (int j=0;j<n;j++) {
                if (grid[i][j] == 1) {
                    curr[j] = 0;
                    continue;
                }

                if (i==0&&j==0) {
                    curr[0] = 1;
                    continue;
                }
                int up = 0;
                if (i > 0) up = prev[j];
                int left = 0;
                if (j > 0) left = curr[j-1];

                curr[j] = up + left;
            }
            prev = curr;
        }

        return prev[n-1];
    }    
}
