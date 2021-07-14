// LintCode 434

/**
 * Definition for a point. class Point { int x; int y; Point() { x = 0; y = 0; }
 * Point(int a, int b) { x = a; y = b; } }
 */

public class Solution {
    /**
     * @param n:         An integer
     * @param m:         An integer
     * @param operators: an array of point
     * @return: an integer array
     */
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        List<Integer> ans = new ArrayList<>();
        if (operators == null)
            return ans;

        parent = new int[n * m];
        rank = new int[n * m];
        count = 0;
        Arrays.fill(parent, -1);
        int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        for (int i = 0; i < operators.length; i++) {
            int row = operators[i].x;
            int col = operators[i].y;
            int cell = row * m + col;
            if (parent[cell] != -1) {
                ans.add(count);
                continue;
            }
            parent[cell] = cell;
            rank[cell] = 1;
            count++;
            for (int j = 0; j < 4; j++) {
                int r = row + dirs[j][0];
                int c = col + dirs[j][1];
                int cellN = r * m + c;
                if (r < 0 || c < 0 || r >= n || c >= m || parent[cellN] == -1) {
                    continue;
                }
                union(cell, cellN);
            }
            ans.add(count);
        }

        return ans;
    }

    int[] parent;
    int[] rank;
    int count;

    public int find(int n) {
        if (parent[n] == n) {
            return n;
        }
        int temp = find(parent[n]);
        parent[n] = temp;
        return temp;
    }

    public void union(int x, int y) {
        int lx = find(x);
        int ly = find(y);
        if (lx != ly) {
            count--;
            if (rank[lx] < rank[ly]) {
                parent[lx] = ly;
            } else if (rank[lx] > rank[ly]) {
                parent[ly] = lx;
            } else {
                parent[lx] = ly;
                rank[ly]++;
            }
        }
    }
}