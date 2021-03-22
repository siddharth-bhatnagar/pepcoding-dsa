import java.io.*;
import java.util.*;

public class HamiltonianPathAndCycle {
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

        int src = Integer.parseInt(br.readLine());
        HashSet<Integer> visited = new HashSet<>();
        hamiltonianPaths(graph, src, visited, src + "", src);
    }

    // A hamiltonian path is such which visits all vertices without visiting any
    // vertex
    // twice. A hamiltonian path becomes a cycle if there is an edge between first
    // and last vertex.
    // Another approach to handle visited array could be using boolean in combination with a count variable.
    public static void hamiltonianPaths(ArrayList<Edge>[] graph, int src, HashSet<Integer> visited, String psf, int osrc) {
        if(visited.size() == graph.length-1){
            System.out.print(psf);
            boolean closedCycle = false;
            for(Edge e: graph[src]){
                if(e.nbr == osrc){
                    closedCycle = true;
                    break;
                }
            }

            if(closedCycle){
                System.out.println("*");
            }
            else {
                System.out.println(".");
            }

            return;
        }
        visited.add(src);
        for (Edge e : graph[src]) {
            if ( visited.contains(e.nbr) == false) {
                hamiltonianPaths(graph, e.nbr, visited, psf + e.nbr, osrc);
            }
        }
        visited.remove(src);
    }

    // public static void hamiltonianPaths(ArrayList<Edge>[] graph, int src, boolean[] visited, String psf, int osrc, int count) {
    //     if(count == graph.length-1){
    //         System.out.print(psf);
    //         boolean closedCycle = false;
    //         for(Edge e: graph[src]){
    //             if(e.nbr == osrc){
    //                 closedCycle = true;
    //                 break;
    //             }
    //         }

    //         if(closedCycle){
    //             System.out.println("*");
    //         }
    //         else {
    //             System.out.println(".");
    //         }

    //         return;
    //     }
    //     visited[src] = true;
    //     count++;
    //     for (Edge e : graph[src]) {
    //         if (visited[e.nbr] == false) {
    //             hamiltonianPaths(graph, e.nbr, visited, psf + e.nbr, osrc, count);
    //         }
    //     }
    //     visited[src] = false;
    //     count--;
    // }

}