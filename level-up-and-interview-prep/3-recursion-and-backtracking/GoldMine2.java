import java.util.*;

public class GoldMine2 {
    static int omax = 0;
    static int cmax = 0;

    public static void getMaxGold(int[][] arr, int i, int j) {
        if (i < 0 || j < 0 || i == arr.length || j == arr[0].length || arr[i][j] == 0) {
            return;
        }

        cmax += arr[i][j];
        arr[i][j] = 0;
        getMaxGold(arr, i - 1, j);
        getMaxGold(arr, i, j - 1);
        getMaxGold(arr, i + 1, j);
        getMaxGold(arr, i, j + 1);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != 0) {
                    getMaxGold(arr, i, j);
                    omax = Math.max(cmax, omax);
                    cmax = 0;
                }
            }
        }

        System.out.println(omax);
        scn.close();
    }
}

// Leetcode 1219

class Solution {
    int r = 0;
    int c = 0;
    int max = 0;
    public int getMaximumGold(int[][] grid) {
        r = grid.length;
        c = grid[0].length;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(grid[i][j] != 0) {
                    dfs(grid, i, j, 0);
                }
            }
        }
        return max;
    }
    
    private void dfs(int[][] grid, int i, int j, int cur) {
        if(i < 0 || i >= r || j < 0 || j >= c || grid[i][j] == 0) {
            max = Math.max(max, cur);
            return;
        }
        int val = grid[i][j];
        grid[i][j] = 0;
        dfs(grid, i + 1, j, cur + val);
        dfs(grid, i - 1, j, cur + val);
        dfs(grid, i, j + 1, cur + val);
        dfs(grid, i, j - 1, cur + val);
        grid[i][j] = val;
    }
}