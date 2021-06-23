// Leetcode 778

class Solution {
    public class Pair implements Comparable<Pair> {
        int x;
        int y;
        int max;

        public Pair(int x, int y, int max) {
            this.x = x;
            this.y = y;
            this.max = max;
        }

        public int compareTo(Pair o) {
            return this.max - o.max;
        }
    }

    public int swimInWater(int[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0, grid[0][0]));
        int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

        while (pq.size() > 0) {
            Pair rem = pq.remove();
            if (rem.x == grid.length - 1 && rem.y == grid[0].length - 1)
                return rem.max;

            if (vis[rem.x][rem.y])
                continue;
            vis[rem.x][rem.y] = true;
            for (int i = 0; i < dirs.length; i++) {
                int rowdash = rem.x + dirs[i][0];
                int coldash = rem.y + dirs[i][1];

                if (rowdash < 0 || coldash < 0 || rowdash >= grid.length || coldash >= grid[0].length
                        || vis[rowdash][coldash]) {
                    continue;
                }

                pq.add(new Pair(rowdash, coldash, Math.max(rem.max, grid[rowdash][coldash])));
            }

        }
        return 0;
    }
}

// O(N*N Log N)
// Modified Dijkstra