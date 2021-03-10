import java.io.*;
import java.util.*;

public class IsGraphConnected {
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
        count = 0;
        boolean[] visited = new boolean[vtces];
        traversal(graph, 0, visited);
        if (count == vtces) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    static int count;

    public static void traversal(ArrayList<Edge>[] graph, int src, boolean[] visited) {
        visited[src] = true;
        count++;
        for (Edge tempnbr : graph[src]) {
            if (visited[tempnbr.nbr] == false) {
                traversal(graph, tempnbr.nbr, visited);
            }
        }
    }
}

// Another method - code similar to get connected components

// import java.io.*;
// import java.util.*;

// public class IsGraphConnected {
// static class Edge {
// int src;
// int nbr;
// int wt;

// Edge(int src, int nbr, int wt) {
// this.src = src;
// this.nbr = nbr;
// this.wt = wt;
// }
// }

// public static void main(String[] args) throws Exception {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// int vtces = Integer.parseInt(br.readLine());
// ArrayList<Edge>[] graph = new ArrayList[vtces];
// for (int i = 0; i < vtces; i++) {
// graph[i] = new ArrayList<>();
// }

// int edges = Integer.parseInt(br.readLine());
// for (int i = 0; i < edges; i++) {
// String[] parts = br.readLine().split(" ");
// int v1 = Integer.parseInt(parts[0]);
// int v2 = Integer.parseInt(parts[1]);
// int wt = Integer.parseInt(parts[2]);
// graph[v1].add(new Edge(v1, v2, wt));
// graph[v2].add(new Edge(v2, v1, wt));
// }

// ArrayList<ArrayList<Integer>> comps = new ArrayList<>();

// // write your code here
// // Important question with traversal for disconnected graph

// boolean[] visited = new boolean[vtces];
// for (int i = 0; i < vtces; i++) {
// if (visited[i] == false) {
// ArrayList<Integer> temp = new ArrayList<>();
// traversal(graph, i, visited, temp);
// comps.add(temp);
// }
// }

// if (comps.size() == 1) {
// System.out.println(true);
// } else {
// System.out.println(false);
// }
// }

// public static void traversal(ArrayList<Edge>[] graph, int src, boolean[]
// visited, ArrayList<Integer> temp) {
// visited[src] = true;
// temp.add(src);

// for (Edge tempnbr : graph[src]) {
// if (visited[tempnbr.nbr] == false) {
// traversal(graph, tempnbr.nbr, visited, temp);
// }
// }
// }
// }