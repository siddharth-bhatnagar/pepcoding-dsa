import java.util.List;

/**
 * Leetcode 120
 * Blog: https://takeuforward.org/data-structure/minimum-path-sum-in-triangular-grid-dp-11/
 */
public class MinPathSumTriangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        // int n = triangle.size();
        // int[][] dp = new int[n][n];
        // for (int i=0;i<n;i++) {
        //     Arrays.fill(dp[i], -1);
        // }
        // return memoized(0, 0, triangle, dp);
        return tabulation(triangle);
    }


    // find all ways from (0,0) to the n - 1 row, any column.
    // Greedy doesn't work because we may miss out on certain cases.
    // No other base case because as soon as we reach the boundary, we return. 
    // O(2 ^ (1 + 2 + 3 + .. + N-1)), O(N)
    private int f(int i, int j, List<List<Integer>> triangle) {
        if (i == triangle.size() - 1) return triangle.get(i).get(j);

        int down = triangle.get(i).get(j) + f(i+1, j, triangle);
        int diagonal = triangle.get(i).get(j) + f(i+1, j+1, triangle);

        return Math.min(down, diagonal);
    }

    // O(NxN), O(N + NxN)
    private int memoized(int i, int j, List<List<Integer>> triangle, int[][] dp) {
        if (i == triangle.size() - 1) return dp[i][j] = triangle.get(i).get(j);

        if (dp[i][j] != -1) return dp[i][j];

        int down = triangle.get(i).get(j) + memoized(i+1, j, triangle, dp);
        int diagonal = triangle.get(i).get(j) + memoized(i+1, j+1, triangle, dp);

        return dp[i][j] = Math.min(down, diagonal);
    }

    // O(NxM), O(NxN)
    private int tabulation(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        // base cases
        for (int i = 0; i < triangle.get(n - 1).size(); i++) {
            dp[n - 1][i] = triangle.get(n-1).get(i);
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int down = triangle.get(i).get(j) + dp[i+1][j];
                int diagonal = triangle.get(i).get(j) + dp[i+1][j+1];
                
                dp[i][j] = Math.min(down, diagonal);
            }
        }

        return dp[0][0];
    }
    
    // O(MxN), O(N)
    private int spaceOp(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] prev = new int[n];

        // base cases
        for (int i = 0; i < triangle.get(n - 1).size(); i++) {
            prev[i] = triangle.get(n-1).get(i);
        }

        for (int i = n - 2; i >= 0; i--) {
            int[] curr = new int[n];
            for (int j = i; j >= 0; j--) {
                int down = triangle.get(i).get(j) + prev[j];
                int diagonal = triangle.get(i).get(j) + prev[j+1];
                
                curr[j] = Math.min(down, diagonal);
            }
            prev = curr;
        }

        return prev[0];
    }
}
