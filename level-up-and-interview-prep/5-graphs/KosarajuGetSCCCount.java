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
    // Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> graph) {

        // Step 1
        Stack<Integer> stack = new Stack<>();
        boolean vis[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (vis[i] == false) {
                dfs1(i, graph, vis, stack);
            }
        }

        // Step 2
        ArrayList<ArrayList<Integer>> newGraph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            newGraph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < V; i++) {
            ArrayList<Integer> nbrs = graph.get(i);
            for (int nbr : nbrs) {
                newGraph.get(nbr).add(i);
            }
        }

        // Step 3
        int scc = 0;
        vis = new boolean[V];
        while (stack.size() > 0) {
            int node = stack.pop();
            if (vis[node] == false) {
                dfs2(newGraph, node, vis);
                scc++;
            }
        }

        return scc;
    }

    public void dfs1(int src, ArrayList<ArrayList<Integer>> graph, boolean[] vis, Stack<Integer> stack) {

        vis[src] = true;
        for (int nbr : graph.get(src)) {
            if (vis[nbr] == false) {
                dfs1(nbr, graph, vis, stack);
            }
        }

        stack.push(src);
    }

    public void dfs2(ArrayList<ArrayList<Integer>> graph, int src, boolean[] vis) {
        vis[src] = true;
        for (int nbr : graph.get(src)) {
            if (vis[nbr] == false) {
                dfs2(graph, nbr, vis);
            }
        }
    }
}
