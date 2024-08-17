/**
 * Refer Blog: https://takeuforward.org/data-structure/grid-unique-paths-dp-on-grids-dp8/
 * Leetcode 62
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        // return f(m-1, n-1);
        // int[][] dp = new int[m][n];
        // for(int i =0;i<m;i++) {
        //     Arrays.fill(dp[i], -1);
        // }

        // return memoized(m-1, n-1, dp);
        // return tabulation(m, n);
        return spaceOp(m, n);
    }

    // f(i, j) -> returns the count of paths from (i,j) to (0,0)
    // O(2^(mxn)), O(pathLength)
    private int f(int i, int j) {
        if (i==0 && j==0) return 1;
        if (i < 0 || j < 0) return 0;

        int up = f(i-1, j);
        int left = f(i, j-1);

        return up + left;
    }

    // O(MxN), O(pathLength + MxN)
    private int memoized(int i, int j, int[][] dp) {
        if (i==0 && j==0) return dp[0][0] = 1;
        if (i < 0 || j < 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int up = f(i-1, j);
        int left = f(i, j-1);

        return dp[i][j] = up + left;
    }

    // O(MxN), O(MxN)
    private int tabulation(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
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
    private int spaceOp(int m, int n) {
        int[] prev = new int[n];

        for (int i=0;i<m;i++) {
            int[] curr = new int[n];
            for (int j=0;j<n;j++) {
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
