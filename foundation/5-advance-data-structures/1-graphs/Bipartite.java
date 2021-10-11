import java.io.*;
import java.util.*;

public class Bipartite {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        System.out.println(solve(graph));
    }

    public static boolean solve(ArrayList<Edge>[] graph) {
        LinkedList<Integer> queue = new LinkedList<>();
        int[] vis = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(vis[i] != 0) continue;
            queue.addLast(i);
            vis[i] = 10;
            while (queue.size() > 0) {
                int src = queue.removeFirst();

                for (Edge e : graph[src]) {
                    if (vis[e.nbr] == 0) {
                        queue.addLast(e.nbr);
                        if (vis[src] == 10) {
                            vis[e.nbr] = 12;
                        } else {
                            vis[e.nbr] = 10;
                        }
                    } else if (vis[e.nbr] == vis[src]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

}
