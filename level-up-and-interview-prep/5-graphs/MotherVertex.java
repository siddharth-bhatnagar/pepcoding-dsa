
// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
            }
            Solution obj = new Solution();
            int ans = obj.findMotherVertex(V, adj);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends

class Solution {
    // Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>> graph) {
        Stack<Integer> stack = new Stack<>();
        boolean vis[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (vis[i] == false) {
                dfs1(i, graph, vis, stack);
            }
        }

        int mv = stack.pop();
        vis = new boolean[V];
        count = 0;
        dfs(mv, graph, vis);
        if (count == V)
            return mv;
        else
            return -1;
    }

    int count;

    public void dfs1(int src, ArrayList<ArrayList<Integer>> graph, boolean[] vis, Stack<Integer> stack) {

        vis[src] = true;
        for (int nbr : graph.get(src)) {
            if (vis[nbr] == false) {
                dfs1(nbr, graph, vis, stack);
            }
        }

        stack.push(src);
    }

    public void dfs(int src, ArrayList<ArrayList<Integer>> graph, boolean[] vis) {
        vis[src] = true;
        count++;
        for (int nbr : graph.get(src)) {
            if (vis[nbr] == false) {
                dfs(nbr, graph, vis);
            }
        }
    }
}