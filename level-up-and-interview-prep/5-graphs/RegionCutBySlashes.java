// Leetcode 959
// DSU
class Solution {
    public int regionsBySlashes(String[] grid) {

        int n = grid.length;
        int dots = n + 1;

        par = new int[dots * dots];
        rank = new int[dots * dots];
        count = 1;

        for (int i = 0; i < par.length; i++) {
            par[i] = i;
            rank[i] = 1;
        }

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0 || i == n || j == n) {
                    int cell = i * dots + j;
                    if (cell != 0) {
                        union(0, cell);
                    }
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            char[] chrs = grid[i].toCharArray();
            for (int j = 0; j < chrs.length; j++) {
                char ch = chrs[j];
                if (ch == '/') {
                    int cell1 = i * dots + (j + 1);
                    int cell2 = (i + 1) * dots + j;
                    union(cell1, cell2);
                } else if (ch == '\\') {
                    int cell1 = i * dots + j;
                    int cell2 = (i + 1) * dots + (j + 1);
                    union(cell1, cell2);
                }
            }
        }

        return count;
    }

    int[] par;
    int[] rank;
    int count;

    public int find(int x) {
        if (par[x] == x) {
            return x;
        }
        int temp = find(par[x]);
        par[x] = temp;
        return temp;
    }

    public void union(int x, int y) {
        int lx = find(x);
        int ly = find(y);
        if (lx != ly) {
            if (rank[lx] > rank[ly]) {
                par[ly] = lx;
            } else if (rank[lx] < rank[ly]) {
                par[lx] = ly;
            } else {
                par[ly] = lx;
                rank[lx]++;
            }
        } else {
            count++;
        }
    }
}