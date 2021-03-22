import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class PerfectFriends {

    public static class Edge {
        int v;
        int n;

        Edge(int v, int n) {
            this.v = v;
            this.n = n;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        // write your code here
        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int v = 0; v < n; v++) {
            graph[v] = new ArrayList<>();
        }

        for (int e = 0; e < k; e++) {
            String line = br.readLine();
            String[] parts = line.split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);

            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();

        boolean visited[] = new boolean[n];

        for(int i=0;i<n;i++){
            if(visited[i] == false) {
                ArrayList<Integer> temp = new ArrayList<>();
                drawTree(graph, i, visited, temp);
                comps.add(temp);
            }
        }

        int pairs = 0;
        for(int i=0;i<comps.size();i++){
            for(int j=i+1;j<comps.size();j++) {
                int count = comps.get(i).size() * comps.get(j).size();
                pairs += count;
            }
        }

        System.out.println(pairs);
    }

    public static void drawTree(ArrayList<Edge>[] graph, int src, boolean[] visited, ArrayList<Integer> temp){
        visited[src] = true;
        temp.add(src);

        ArrayList<Edge> nbrs = graph[src];
        for(Edge nbr: nbrs) {
            if(visited[nbr.n] == false) {
                drawTree(graph, nbr.n, visited, temp);
            }
        }
    }

}