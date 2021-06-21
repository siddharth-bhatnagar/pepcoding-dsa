// Leetcode 785

class Solution {
    // Adjacency list given in form of 2D matrix
    // Slight optimisation would be to use visited outside the vertices loop
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        Arrays.fill(vis, -1);

        for (int i = 0; i < n; i++) {
            LinkedList<Integer> mq = new LinkedList<>();
            if(vis[i] != -1) {
                continue;
            }
            mq.addLast(i);
            vis[i] = 10;
            while (mq.size() > 0) {
                int rem = mq.removeFirst();
                int[] nbrs = graph[rem];
                for (int nbr : nbrs) {
                    if (vis[nbr] == -1) {
                        mq.addLast(nbr);
                        if (vis[rem] == 10)
                            vis[nbr] = 12;
                        else
                            vis[nbr] = 10;
                    } else {
                        if (vis[nbr] == vis[rem])
                            return false;
                    }
                }

            }
        }
        return true;
    }
}