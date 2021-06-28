// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());

            for (int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());

            for (int i = 1; i <= E; i++) {
                int u = Integer.parseInt(sc.next());
                int v = Integer.parseInt(sc.next());

                // adding directed edgese between
                // vertex 'u' and 'v'
                adj.get(u).add(v);
            }

            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    Stack<Integer> stack = new Stack<>();

    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {

        // step 1
        LinkedList<Integer> stack = new LinkedList<>();
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs1(adj, i, stack, vis);
            }
        }

        // step 2
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            ArrayList<Integer> nbrs = adj.get(i);
            for (int nbr : nbrs) {
                graph.get(nbr).add(i);
            }
        }

        // step 3
        int ans = 0;
        vis = new boolean[V];

        while (stack.size() > 0) {
            int rem = stack.removeFirst();
            if (!vis[rem]) {
                dfs2(graph, rem, vis);
                ans++;
            }
        }
        return ans;
    }

    public void dfs1(ArrayList<ArrayList<Integer>> adj, int src, LinkedList<Integer> stack, boolean[] vis) {
        vis[src] = true;

        ArrayList<Integer> nbrs = adj.get(src);
        for (int nbr : nbrs) {
            if (!vis[nbr]) {
                dfs1(adj, nbr, stack, vis);
            }
        }

        stack.addFirst(src);
    }

    public void dfs2(ArrayList<ArrayList<Integer>> adj, int src, boolean[] vis) {
        vis[src] = true;

        ArrayList<Integer> nbrs = adj.get(src);
        for (int nbr : nbrs) {
            if (!vis[nbr]) {
                dfs2(adj, nbr, vis);
            }
        }
    }

}
