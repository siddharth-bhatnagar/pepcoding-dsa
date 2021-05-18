import java.io.*;
import java.util.*;

public class Main {
    // ci -- current item | ti -- total items
    public static void permutations(int[] boxes, int ci, int ti) {
        // write your code here
        int n = boxes.length;
        if (ci == ti + 1) {
            for (int item : boxes) {
                System.out.print(item);
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (boxes[i] == 0) {
                boxes[i] = ci;
                permutations(boxes, ci + 1, ti);
                boxes[i] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        permutations(new int[nboxes], 1, ritems);
    }

}