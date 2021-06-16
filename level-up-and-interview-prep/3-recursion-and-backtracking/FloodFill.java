// Leetcode 733

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if(color != newColor)solve(image, sr, sc, newColor, color, new boolean[image.length][image[0].length]);
        return image;
    }
    
    public void solve(int[][] image, int sr, int sc, int newColor, int oldColor, boolean[][] vis) {
        if(image[sr][sc] != oldColor || vis[sr][sc] == true) {
            return;
        }
        
        image[sr][sc] = newColor;
        vis[sr][sc] = true;
        if(sr >= 1) solve(image, sr-1, sc, newColor, oldColor, vis);
        if(sc >= 1) solve(image, sr, sc-1, newColor, oldColor, vis);
        if(sr < image.length-1) solve(image, sr+1, sc, newColor, oldColor, vis);
        if(sc < image[0].length-1) solve(image, sr, sc+1, newColor, oldColor, vis);
        vis[sr][sc] = false;
    }
}