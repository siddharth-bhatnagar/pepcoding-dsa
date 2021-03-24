import java.io.*;
import java.util.*;

public class MinCostInMaze {
    
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int[][] grid = new int[scn.nextInt()][scn.nextInt()];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                grid[i][j] = scn.nextInt();
            }
        }

        System.out.println(minPathSum(grid));
    }
    
    public static int minPathSum(int[][] grid) {
        return minPath(grid, grid.length - 1, grid[0].length - 1, new int[grid.length][grid[0].length]);
    }

    public static int minPath(int[][] grid, int row, int col, int[][] dp) {
        if (row < 0 || col < 0)
            return Integer.MAX_VALUE;

        if (row == 0 && col == 0)
            return grid[0][0];

        if (dp[row][col] != 0)
            return dp[row][col];

        int left = minPath(grid, row, col - 1, dp);
        int up = minPath(grid, row - 1, col, dp);

        int sum = Math.min(left, up) + grid[row][col];
        dp[row][col] = sum;
        return sum;
    }
}