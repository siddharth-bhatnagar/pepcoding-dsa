import java.io.*;
import java.util.*;

public class Main {

    public static class PriorityQueue {
        ArrayList<Integer> data;

        public PriorityQueue() {
            data = new ArrayList<>();
        }

        public void swap(int idx1, int idx2) {
            int idx1elem = data.get(idx1);
            int idx2elem = data.get(idx2);

            data.set(idx1, idx2elem);
            data.set(idx2, idx1elem);
        }

        public void upheapify(int idx) {
            if (idx == 0) {
                return;
            }

            int pidx = (idx - 1) / 2;
            if (data.get(idx) < data.get(pidx)) {
                swap(idx, pidx);
                upheapify(pidx);
            }
        }

        public void downheapify(int idx) {
            int minidx = idx;

            int lidx = 2 * idx + 1;
            int ridx = 2 * idx + 2;

            if (lidx < data.size() && data.get(lidx) < data.get(minidx)) {
                minidx = lidx;
            }

            if (ridx < data.size() && data.get(ridx) < data.get(minidx)) {
                minidx = ridx;
            }

            if (minidx == idx) {

            } else {
                swap(idx, minidx);
                downheapify(minidx);
            }
        }

        public void add(int val) {
            // write your code here
            data.add(val);
            upheapify(data.size() - 1);
        }

        public int remove() {
            // write your code here
            if (data.size() == 0) {
                System.out.println("Underflow");
                return -1;
            }

            swap(0, data.size() - 1);
            int ans = data.remove(data.size() - 1);
            downheapify(0);
            return ans;
        }

        public int peek() {
            // write your code here
            if (data.size() == 0) {
                System.out.println("Underflow");
                return -1;
            }

            return data.get(0);
        }

        public int size() {
            // write your code here
            return data.size();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue qu = new PriorityQueue();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("add")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
            } else if (str.startsWith("remove")) {
                int val = qu.remove();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("peek")) {
                int val = qu.peek();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(qu.size());
            }
            str = br.readLine();
        }
    }
}