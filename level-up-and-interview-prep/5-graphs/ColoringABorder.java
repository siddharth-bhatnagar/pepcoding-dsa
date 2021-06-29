// Leetcode 1034

class Solution {
    boolean[][] vis;
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        vis = new boolean[grid.length][grid[0].length];
        dfs(grid, r0, c0, color, grid[r0][c0]);
        return grid;
    }
    
    public void dfs(int[][] grid, int row, int col, int color, int oldColor) {
        vis[row][col] = true;
        int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        int callCount = 0;
        for(int i=0;i<dirs.length;i++) {
            int r = row + dirs[i][0];
            int c = col + dirs[i][1];
            
            if(r>=0 && c>=0 && r<grid.length && c<grid[0].length) {
                if(vis[r][c]) callCount++;
                else if(grid[r][c] == oldColor) {
                    callCount++;
                    dfs(grid, r, c, color, oldColor);
                }
            }
        }
        
        if(callCount != 4) {
            grid[row][col] = color;
        }
    }
}