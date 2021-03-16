import java.io.*;
import java.util.*;

public class BreadthFirstTraversal {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    public static class Pair {
        int vtx;
        String psf;

        public Pair(int vtx, String psf) {
            this.vtx = vtx;
            this.psf = psf;
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
        bfs(src, graph);
    }

    public static void bfs(int src, ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        Queue<Pair> q = new ArrayDeque<>();
        Pair scp = new Pair(src, src+"");
        q.add(scp);
        vis[src] = true;
        while(q.size()>0){
            scp = q.remove();
            System.out.println(scp.vtx + "@" + scp.psf);

            ArrayList<Edge> nbrs = graph[scp.vtx];
            for(Edge neighbour: nbrs) {
                if(vis[neighbour.nbr] == false) {
                    vis[neighbour.nbr] = true;
                    q.add(new Pair(neighbour.nbr, scp.psf + neighbour.nbr));
                }
            }
        }
    }
}