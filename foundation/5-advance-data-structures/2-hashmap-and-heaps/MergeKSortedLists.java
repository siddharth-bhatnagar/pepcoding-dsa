import java.io.*;
import java.util.*;

public class Main {
    
    public static class Pair implements Comparable<Pair> {
        int val;
        int list;
        int idx;

        public Pair(int val, int list, int idx) {
            this.val = val;
            this.list = list;
            this.idx = idx;
        }

        public int compareTo(Pair obj) {
            return this.val - obj.val;
        }
    }
    
    public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {
        ArrayList<Integer> rv = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        // code
        for(int i=0;i<lists.size();i++) {
            pq.add(new Pair(lists.get(i).get(0), i, 0));
        }

        while(pq.size()>0) {
            Pair rem= pq.remove();
            rv.add(rem.val);

            int newIdx = rem.idx + 1;
            int newListNo = rem.list;
            
            if(newIdx < lists.get(newListNo).size()) {
                pq.add(new Pair(lists.get(newListNo).get(newIdx), newListNo, newIdx));
            }
        }

        
        return rv;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ArrayList<Integer> list = new ArrayList<>();

            int n = Integer.parseInt(br.readLine());
            String[] elements = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                list.add(Integer.parseInt(elements[j]));
            }

            lists.add(list);
        }

        ArrayList<Integer> mlist = mergeKSortedLists(lists);
        for (int val : mlist) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

}