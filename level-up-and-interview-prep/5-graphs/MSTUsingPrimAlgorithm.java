import java.util.*;

public class MSTUsingPrimAlgorithm {
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
        for (int i = 1; i <= n; i++) {
            graph.add(new ArrayList<Pair>());
        }

        for (int i = 1; i <= m; i++) {
            int u = scn.nextInt()-1;
            int v = scn.nextInt()-1;
            int wt = scn.nextInt();

            graph.get(u).add(new Pair(v, wt));
            graph.get(v).add(new Pair(u, wt));
        }

        HashSet<Integer> set = new HashSet<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        long ans = 0;
        pq.add(new Pair(0, 0));
        while (pq.size() > 0) {
            Pair rem = pq.remove();
            if(set.contains(rem.vtx)) continue;
            set.add(rem.vtx);

            for(Pair nbr: graph.get(rem.vtx)) {
                if(set.contains(nbr.vtx)) continue;
                pq.add(new Pair(nbr.vtx, nbr.wt));
            }

            ans += rem.wt;
        }
        System.out.println(ans);
        scn.close();
    }
}

// complexity Elog E which is equivalent to ELogV
// The above code is for 1 based indexing 