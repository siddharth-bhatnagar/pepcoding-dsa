/*
 * Did not understand, stupid question
 * refer: https://leetcode.com/problems/cherry-pickup/solutions/5478591/most-efficient-2-intuitions-explained-with-pictures-best-explanation/
 * Leetcode 741
 */
public class CherryPick {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        Integer[][][] memo = new Integer[n][n][n];
        return Math.max(0, dp(grid, memo, 0, 0, 0));
    }
    
    private int dp(int[][] grid, Integer[][][] memo, int r1, int c1, int c2) {
        int n = grid.length;
        int r2 = r1 + c1 - c2;
        
        // Out of bounds or thorn cell
        if (r1 >= n || r2 >= n || c1 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1)
            return Integer.MIN_VALUE;
        
        // Memoization check
        if (memo[r1][c1][c2] != null)
            return memo[r1][c1][c2];
        
        // Base case: reached bottom-right corner
        if (r1 == n - 1 && c1 == n - 1)
            return grid[r1][c1];
        
        // Calculate cherries collected at (r1, c1) and (r2, c2)
        int cherries = (r1 == r2 && c1 == c2) ? grid[r1][c1] : grid[r1][c1] + grid[r2][c2];
        
        // Move right or down
        int maxCherries = Math.max(dp(grid, memo, r1, c1 + 1, c2), dp(grid, memo, r1 + 1, c1, c2));
        // Move down or right
        maxCherries = Math.max(maxCherries, dp(grid, memo, r1, c1 + 1, c2 + 1));
        maxCherries = Math.max(maxCherries, dp(grid, memo, r1 + 1, c1, c2 + 1));
        
        // Memoize the result
        memo[r1][c1][c2] = (maxCherries == Integer.MIN_VALUE) ? Integer.MIN_VALUE : maxCherries + cherries;
        
        return memo[r1][c1][c2];
    }
}
