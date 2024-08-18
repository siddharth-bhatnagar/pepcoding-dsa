/**
 * Blog: https://takeuforward.org/data-structure/3-d-dp-ninja-and-his-friends-dp-13/
 * Leetcode 1463: Cherry Pickup II
 */
public class NinjaAndFriends3D {
    public int solve(int n, int m, int grid[][]) {
        
        // int[][][] dp = new int[n][m][m];
        // for (int i=0;i<n;i++) {
        //     for(int j=0;j<m;j++) {
        //         Arrays.fill(dp[i][j], -1);
        //     }
        // }
        // return f(0, 0, m-1, grid, n, m);
        // return memoized(0, 0, m-1, grid, n, m, dp);
        // return tabulation(n, m, grid); 
        return spaceOp(n, m, grid);
    }
    
    // starting points fixed as (0, 0) & (0, m-1).
    // Greedy won't work because of uniformity issue.
    // if both robots reach the same cell, that needs to be included once only.
    // Compute all ways, maximize the sum (total number of chocolates).
    // Observation -> Since both robots are moving simultaneously and are moving in the next row 
    // at the same time, they are bound to reach the last row together. 
    // f(i, j1, j2) -> returns the maximum number of chocolates from respective starting positions 
    // till ith row, j1th column for robot 1, j2th column (robot2). 
    // Movement
    // i + 1, for each of j1, j1-1,j1+1 ; j2 can go j2-1, j2, j2+1, 9 combinations
    // O(Exponential), O(N);
    private int f(int i, int j1, int j2, int[][] grid, int n, int m) {
        // Base Cases
        if (j1 < 0 || j2 < 0 || j1 > m - 1 || j2 > m - 1) {
            return (int) Math.pow(-10, 9);
        }
        
        if (i == n - 1) {
            if (j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }
        
        int omax = Integer.MIN_VALUE;
        for (int j1Delta=-1;j1Delta<=1;j1Delta++) {
            for (int j2Delta=-1;j2Delta<=1;j2Delta++) {
                int nj1 = j1Delta + j1;
                int nj2 = j2Delta + j2;
                
                int choc = f(i+1, nj1, nj2, grid, n, m);
                if (j1 == j2) choc += grid[i][j1];
                else choc += grid[i][j1] + grid[i][j2];
                
                omax = Math.max(omax, choc);
            }
        }
        
        return omax;
    }
    
    // O(MxNxN * 9), O(N + MxNxN)
    private int memoized(int i, int j1, int j2, int[][] grid, int n, int m, int[][][] dp) {
        // Base Cases
        if (j1 < 0 || j2 < 0 || j1 > m - 1 || j2 > m - 1) {
            return (int) Math.pow(-10, 9);
        }
        
        if (i == n - 1) {
            if (j1 == j2) return dp[i][j1][j2] = grid[i][j1];
            else return dp[i][j1][j2] = grid[i][j1] + grid[i][j2];
        }
        
        if (dp[i][j1][j2] != -1) return dp[i][j1][j2];
        
        int omax = Integer.MIN_VALUE;
        for (int j1Delta=-1;j1Delta<=1;j1Delta++) {
            for (int j2Delta=-1;j2Delta<=1;j2Delta++) {
                int nj1 = j1Delta + j1;
                int nj2 = j2Delta + j2;
                
                int choc = memoized(i+1, nj1, nj2, grid, n, m, dp);
                if (j1 == j2) choc += grid[i][j1];
                else choc += grid[i][j1] + grid[i][j2];
                
                omax = Math.max(omax, choc);
            }
        }
        
        return dp[i][j1][j2] = omax;
    }
    
    // O(MxNxN * 9), O(MxNxN)
    private int tabulation(int n, int m, int[][] grid) {
        int[][][] dp = new int[n][m][m];
        
        // Base Case
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2) {
                    dp[n - 1][j1][j2] = grid[n - 1][j1];
                } else {
                    dp[n - 1][j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
                }
            }
        }
        
        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int omax = Integer.MIN_VALUE;
                    for (int j1Delta=-1;j1Delta<=1;j1Delta++) {
                        for (int j2Delta=-1;j2Delta<=1;j2Delta++) {
                            int nj1 = j1Delta + j1;
                            int nj2 = j2Delta + j2;
                            
                            int choc = 0;
                            if (nj1 < 0 || nj2 < 0 || nj1 > m-1 || nj2 > m-1) {
                                choc += (int) Math.pow(-10, 9);
                            } else {
                                choc += dp[i+1][nj1][nj2];
                            }
                            
                            if (j1 == j2) choc += grid[i][j1];
                            else choc += grid[i][j1] + grid[i][j2];
                            
                            omax = Math.max(omax, choc);
                        }
                    }
                    dp[i][j1][j2] = omax;
                }
            }
        }
        
        return dp[0][0][m-1];
    }
    
    // O(NxMxM * 9), O(MxM)
    private int spaceOp(int n, int m, int[][] grid) {
        int[][] prev = new int[m][m];
        
        // Base Case
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2) {
                    prev[j1][j2] = grid[n - 1][j1];
                } else {
                    prev[j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
                }
            }
        }
        
        for (int i = n - 2; i >= 0; i--) {
            int[][] curr = new int[m][m];
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int omax = Integer.MIN_VALUE;
                    for (int j1Delta=-1;j1Delta<=1;j1Delta++) {
                        for (int j2Delta=-1;j2Delta<=1;j2Delta++) {
                            int nj1 = j1Delta + j1;
                            int nj2 = j2Delta + j2;
                            
                            int choc = 0;
                            if (nj1 < 0 || nj2 < 0 || nj1 > m-1 || nj2 > m-1) {
                                choc += (int) Math.pow(-10, 9);
                            } else {
                                choc += prev[nj1][nj2];
                            }
                            
                            if (j1 == j2) choc += grid[i][j1];
                            else choc += grid[i][j1] + grid[i][j2];
                            
                            omax = Math.max(omax, choc);
                        }
                    }
                    curr[j1][j2] = omax;
                }
            }
            prev = curr;
        }
        
        return prev[0][m-1];
    }
}
