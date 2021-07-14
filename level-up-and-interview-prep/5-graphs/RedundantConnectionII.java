// Leetcode 685

class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] indegree = new int[n + 1];
        Arrays.fill(indegree, -1);
        parent = new int[n + 1];
        rank = new int[n + 1];
        int p1 = -1; // possible ans edge
        int p2 = -1; // ans edge if p1 fails

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            int[] edge = edges[i];
            int u = edge[0];
            int v = edge[1];

            if (indegree[v] == -1) {
                indegree[v] = i;
            } else {
                p1 = i;
                p2 = indegree[v];
            }
        }

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int u = edge[0];
            int v = edge[1];

            if (i == p1)
                continue;

            boolean f = union(u, v);

            if (f == true) {
                if (p1 == -1) {
                    return edge;
                } else {
                    return edges[p2];
                }
            }
        }

        return edges[p1];
    }

    int[] parent;
    int[] rank;

    public int find(int x) {
        if (parent[x] == x)
            return x;
        int temp = find(parent[x]);
        parent[x] = temp;
        return temp;
    }

    public boolean union(int x, int y) {
        int lx = find(x);
        int ly = find(y);

        if (ly == lx)
            return true;

        if (rank[lx] < rank[ly]) {
            parent[lx] = ly;
        } else if (rank[lx] > rank[ly]) {
            parent[ly] = lx;
        } else {
            parent[ly] = lx;
            rank[lx]++;
        }

        return false;
    }
}
