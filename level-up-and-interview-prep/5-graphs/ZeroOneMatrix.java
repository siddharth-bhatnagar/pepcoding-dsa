// Leetcode 542

class Solution {
    public class Pair {
        int row, col, level;
        public Pair(int row, int col, int level) {
            this.row = row;
            this.col = col;
            this.level = level;
        }
    }
    
    public int[][] updateMatrix(int[][] mat) {
        int[][] ans = new int[mat.length][mat[0].length];
        LinkedList<Pair> mq = new LinkedList<>();
        boolean vis[][] = new boolean[mat.length][mat[0].length];
        
        for(int i=0;i<mat.length;i++) {
            for(int j=0;j< mat[i].length;j++) {
                if(mat[i][j] == 0) {
                    mq.addLast(new Pair(i, j, 0));
                    vis[i][j] = true;
                }
            }
        }
        
        int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        while(mq.size() > 0) {
            int size = mq.size();
            while(size-- > 0) {
                Pair rem = mq.removeFirst();
                for(int i=0;i<dirs.length;i++) {
                    int r = rem.row + dirs[i][0];
                    int c = rem.col + dirs[i][1];
                    
                    if(r < 0 || c <0 || r>=mat.length || c >= mat[0].length || vis[r][c] == true) continue;
                    
                    vis[r][c] = true;
                    
                    mq.addLast(new Pair(r, c, rem.level + 1));
                    ans[r][c] = rem.level + 1;
                }
            }
        }
        
        return ans;
    }
}