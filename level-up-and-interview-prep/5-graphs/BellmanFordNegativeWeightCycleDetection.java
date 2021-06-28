// GFG

// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class BellmanFordNegativeWeightCycleDetection {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] edges = new int[m][3];
            for (int i = 0; i < m; i++) {
                String S2[] = br.readLine().trim().split(" ");
                for (int j = 0; j < 3; j++)
                    edges[i][j] = Integer.parseInt(S2[j]);
            }
            Solution obj = new Solution();
            int ans = obj.isNegativeWeightCycle(n, edges);
            System.out.println(ans);
        }
    }

    public class Solution {
        public int isNegativeWeightCycle(int n, int[][] edges) {
            int path[] = new int[n];
            Arrays.fill(path, Integer.MAX_VALUE);
            path[0] = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < edges.length; j++) {
                    int u = edges[j][0];
                    int v = edges[j][1];
                    int wt = edges[j][2];

                    if (path[u] == Integer.MAX_VALUE)
                        continue;

                    if (path[u] + wt < path[v]) {
                        path[v] = path[u] + wt;
                    }
                }
            }

            for (int j = 0; j < edges.length; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                int wt = edges[j][2];

                if (path[u] + wt < path[v]) {
                    return 1;
                }
            }

            return 0;
        }
    }
}

// If edges not given, traverse on graph and collect all edges