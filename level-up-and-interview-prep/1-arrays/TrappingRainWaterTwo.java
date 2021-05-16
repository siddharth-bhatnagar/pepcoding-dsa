// Leetcode 407

class Solution {
    public class Pair implements Comparable<Pair> {
        int i;
        int j;
        int val;

        public Pair(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }

        @Override
        public int compareTo(Pair object) {
            return this.val - object.val;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        if (m == 1 || n == 1)
            return 0;

        // Minimum Priority Queue
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        visited[0][n - 1] = true;
        visited[m - 1][0] = true;
        visited[m - 1][n - 1] = true;
        for (int i = 1; i < n - 1; i++) {
            pq.add(new Pair(0, i, heightMap[0][i]));
            pq.add(new Pair(m - 1, i, heightMap[m - 1][i]));
            visited[0][i] = true;
            visited[m - 1][i] = true;
        }

        for (int i = 1; i < m - 1; i++) {
            pq.add(new Pair(i, 0, heightMap[i][0]));
            pq.add(new Pair(i, n - 1, heightMap[i][n - 1]));
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }

        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        int ans = 0;
        while (!pq.isEmpty()) {
            Pair cell = pq.remove();
            for (int[] dir : directions) {
                int r = cell.i + dir[0];
                int c = cell.j + dir[1];
                if (r >= 0 && r <= m - 1 && c >= 0 && c <= n - 1 && visited[r][c] == false) {
                    ans += Math.max(0, cell.val - heightMap[r][c]);
                    pq.add(new Pair(r, c, Math.max(heightMap[r][c], cell.val)));
                    visited[r][c] = true;
                }
            }
        }
        return ans;
    }
}