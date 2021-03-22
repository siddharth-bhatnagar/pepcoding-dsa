import java.io.*;
import java.util.*;

public class Main {

    public static class PriorityQueue {
        ArrayList<Integer> data;

        public PriorityQueue() {
            data = new ArrayList<>();
        }

        public void add(int val) {
            // write your code here
            data.add(val);
            upheapify(data.size() - 1);
        }

        public void upheapify(int idx) {

            if (idx == 0) {
                return;
            }

            int pidx = (idx - 1) / 2;
            if (data.get(idx) < data.get(pidx)) {
                int idxelem = data.get(idx);
                int pidxelem = data.get(pidx);

                data.set(idx, pidxelem);
                data.set(pidx, idxelem);

                upheapify(pidx);
            }
        }

        public int remove() {
            // write your code here

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