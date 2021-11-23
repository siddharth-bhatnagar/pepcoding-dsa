// Leetcode 834

class Solution {
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        // Making Adjaceny List
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        // Initializing the list
        for (int i = 0; i < N; i++) {
            tree.add(new ArrayList<>());
        }

        int[] count = new int[N];
        int[] ans = new int[N];

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        traversal(tree, count, 0, new boolean[N]);
        levelOrder(tree, ans, count, 0, new boolean[N]);
        solve(tree, ans, count, 0, new boolean[N]);
        return ans;
    }

    public void solve(ArrayList<ArrayList<Integer>> tree, int[] ans, int[] count, int src, boolean[] vis) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(src);
        vis[src] = true;
        while (queue.size() > 0) {
            int size = queue.size();
            while (size-- > 0) {
                int rem = queue.removeFirst();
                ArrayList<Integer> children = tree.get(rem);
                for (int child : children) {
                    if (vis[child] == false) {
                        ans[child] = ans[rem] - count[child] + (count.length - count[child]);
                        vis[child] = true;
                        queue.addLast(child);
                    }
                }
            }
        }
    }

    public int traversal(ArrayList<ArrayList<Integer>> tree, int[] count, int src, boolean[] vis) {

        vis[src] = true;
        ArrayList<Integer> children = tree.get(src);

        for (int child : children) {
            if (!vis[child]) {
                int temp = traversal(tree, count, child, vis);
                count[src] += temp;
            }
        }

        count[src] += 1;
        return count[src];
    }

    public void levelOrder(ArrayList<ArrayList<Integer>> tree, int[] ans, int[] count, int src, boolean[] vis) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(src);
        vis[src] = true;
        int level = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            while (size-- > 0) {
                int rem = queue.removeFirst();
                ans[src] += level;

                ArrayList<Integer> children = tree.get(rem);
                for (int child : children) {
                    if (vis[child] == false) {
                        vis[child] = true;
                        queue.addLast(child);
                    }
                }
            }
            level++;
        }
    }
}

// O(N)
// Could have been better written
// Re-do