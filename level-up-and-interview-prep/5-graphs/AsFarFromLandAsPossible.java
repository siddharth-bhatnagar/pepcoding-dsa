//  Leetcode 1162

class Solution {

    public class Pair {
        int row, col, dist;

        public Pair(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    public int maxDistance(int[][] grid) {
        int n = grid.length;
        LinkedList<Pair> mq = new LinkedList<>();
        boolean vis[][] = new boolean[n][n];
        int land = 0, water = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    mq.addLast(new Pair(i, j, 0));
                    vis[i][j] = true;
                    land++;
                } else {
                    water++;
                }
            }
        }

        if (land == 0 || water == 0) {
            return -1;
        }

        int ans = Integer.MIN_VALUE;
        int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        while (mq.size() > 0) {
            Pair rem = mq.removeFirst();
            ans = Math.max(ans, rem.dist);
            for (int i = 0; i < dirs.length; i++) {
                int r = dirs[i][0] + rem.row;
                int c = dirs[i][1] + rem.col;

                if (r < 0 || c < 0 || r == n || c == n || vis[r][c]) {
                    continue;
                }

                mq.addLast(new Pair(r, c, rem.dist + 1));
                vis[r][c] = true;
            }
        }

        return ans;
    }
}