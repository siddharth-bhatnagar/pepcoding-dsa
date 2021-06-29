import java.io.*;
import java.util.*;

public class MinCostToConnectAllCities {
    public static class Pair implements Comparable<Pair> {
        int v;
        int w;

        public Pair(int v, int w) {
            this.v = v;
            this.w = w;
        }

        public int compareTo(Pair o) {
            return this.w - o.w;
        }
    }

    public static class Edge {
        int u;
        int v;
        int w;

        public Edge(int u,int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int vtces = scn.nextInt();
        int edges = scn.nextInt();

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for(int i=0;i<vtces;i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<edges;i++) {
            int u = scn.nextInt();
            int v = scn.nextInt();
            int w = scn.nextInt();

            graph.get(u).add(new Edge(u, v, w));
            graph.get(v).add(new Edge(v, u, w));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0));
        boolean[] vis = new boolean[vtces];
        long cost = 0;
        while(pq.size()>0) {
            Pair rem = pq.remove();
            if(vis[rem.v] == true) continue;

            vis[rem.v] = true;
            cost += rem.w;
            for(Edge nbr: graph.get(rem.v)) {
                if(vis[nbr.v] == true) continue;
                pq.add(new Pair(nbr.v, nbr.w));
            }
        }

        System.out.println(cost);
        scn.close();
    }
}