import java.io.*;
import java.util.*;

public class IterativeDFS {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
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
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        int src = Integer.parseInt(br.readLine());

        dfs(graph, src);
    }

    private static class Pair {
        int vtx;
        String psf;

        public Pair(int vtx, String psf) {
            this.vtx = vtx;
            this.psf = psf;
        }
    }

    public static void dfs(ArrayList<Edge>[] graph, int src) {
        Stack<Pair> stack = new Stack<>();
        HashSet<Integer> vis = new HashSet<>();
        // vis.add(src);
        stack.push(new Pair(src, "" + src));

        while (stack.size() > 0) {
            Pair top = stack.pop();
            if (vis.contains(top.vtx))
                continue;
            vis.add(top.vtx);
            System.out.println(top.vtx + "@" + top.psf);

            for (Edge e : graph[top.vtx]) {
                if (!vis.contains(e.nbr)) {
                    stack.push(new Pair(e.nbr, top.psf + e.nbr));
                }
            }
        }
    }
}
