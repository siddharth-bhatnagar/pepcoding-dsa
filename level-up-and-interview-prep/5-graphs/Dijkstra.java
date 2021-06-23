import java.util.*;

public class Dijkstra {
    public static class Pair implements Comparable<Pair> {
        int vtx;
        int wt;

        public Pair(int vtx, int wt) {
            this.vtx = vtx;
            this.wt = wt;
        }

        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Pair>());
        }

        // undirected graph
        for (int i = 0; i <m; i++) {
            int u = scn.nextInt();
            int v = scn.nextInt();
            int wt = scn.nextInt();

            graph.get(u).add(new Pair(v, wt));
            graph.get(v).add(new Pair(u, wt));
        }

        int src = scn.nextInt();

        int[] vis = new int[n];
        Arrays.fill(vis, -1);
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));
        while (pq.size() > 0) {
            Pair rem = pq.remove();
            if(vis[rem.vtx] != -1) continue;

            vis[rem.vtx] = rem.wt;
            
            for(Pair nbr: graph.get(rem.vtx)) {
                if(vis[nbr.vtx] == -1)
                    pq.add(new Pair(nbr.vtx, nbr.wt + rem.wt));
            }
        }
        
        for(int num: vis) {
            System.out.print(num + " ");
        }
        scn.close();
    }
}

// complexity Elog E which is equivalent to ELogV
 